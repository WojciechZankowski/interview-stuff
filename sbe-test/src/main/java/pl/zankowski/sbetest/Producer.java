package pl.zankowski.sbetest;

import org.agrona.concurrent.UnsafeBuffer;
import pl.zankowski.sbetest.sbe.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 * @author Wojciech Zankowski
 */
public class Producer {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        Socket connectionSocket = welcomeSocket.accept();
        InputStream inFromClient = connectionSocket.getInputStream();
        byte[] message = new byte[1024];
        inFromClient.read(message);

        decodeRequest(message);

        while (true) {
            Thread.sleep(1000);

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.write(createMessage());
        }
    }

    private static void decodeRequest(byte[] message) {
        final MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
        final MarketDataRequestDecoder marketDataDecoder = new MarketDataRequestDecoder();
        final UnsafeBuffer decoderBuffer = new UnsafeBuffer(message);

        final StringBuilder builder = new StringBuilder();

        messageHeaderDecoder.wrap(decoderBuffer, 0);

        final int actingVersion = messageHeaderDecoder.version();
        final int actingBlockLength = messageHeaderDecoder.blockLength();

        marketDataDecoder.wrap(decoderBuffer, 0 + messageHeaderDecoder.encodedLength(), actingBlockLength, actingVersion);

        byte[] symbolBytes = new byte[MarketDataRequestDecoder.symbolLength()];
        marketDataDecoder.getSymbol(symbolBytes, 0);
        builder.append("symbol=");
        builder.append(new String(symbolBytes));

        byte[] exchangeBytes = new byte[MarketDataRequestDecoder.securityExchangeLength()];
        marketDataDecoder.getSecurityExchange(exchangeBytes, 0);
        builder.append("#exchange=");
        builder.append(new String(exchangeBytes));

        System.out.println(builder.toString());
    }

    private static byte[] createMessage() {
        final int bufferIndex = 0;
        int length = 0;

        final MessageHeaderEncoder messageHeaderEncoder = new MessageHeaderEncoder();

        final MarketDataIncrementalRefreshTradesEncoder marketDataEncoder = new MarketDataIncrementalRefreshTradesEncoder();

        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        final UnsafeBuffer encodeBuffer = new UnsafeBuffer(byteBuffer);

        messageHeaderEncoder
                .wrap(encodeBuffer, bufferIndex)
                .blockLength(marketDataEncoder.sbeBlockLength())
                .templateId(marketDataEncoder.sbeTemplateId())
                .schemaId(marketDataEncoder.sbeSchemaId())
                .version(marketDataEncoder.sbeSchemaVersion());

        length += messageHeaderEncoder.encodedLength();

        marketDataEncoder
                .wrap(encodeBuffer, bufferIndex + messageHeaderEncoder.encodedLength())
                .transactTime(System.currentTimeMillis())
                .eventTimeDelta(1000)
                .matchEventIndicator(MatchEventIndicator.END_EVENT);

        final MarketDataIncrementalRefreshTradesEncoder.MdIncGrpEncoder mdIncGrp = marketDataEncoder.mdIncGrpCount(1);

        mdIncGrp.next();
        mdIncGrp.tradeId(System.currentTimeMillis());
        mdIncGrp.securityId(123456);
        mdIncGrp.mdEntryPx().mantissa(RANDOM.nextInt(100));
        mdIncGrp.mdEntrySize().mantissa(RANDOM.nextInt(77));
        mdIncGrp.numberOfOrders(RANDOM.nextInt(10));
        mdIncGrp.mdUpdateAction(RANDOM.nextBoolean() ? MDUpdateAction.NEW : MDUpdateAction.CHANGE);
        mdIncGrp.rptSeq((short) 1);
        mdIncGrp.aggressorSide(RANDOM.nextBoolean() ? Side.BUY : Side.SELL);

        length += marketDataEncoder.encodedLength();

        byteBuffer.limit(length);

        return byteBuffer.array();
    }

}
