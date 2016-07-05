package pl.zankowski.sbetest;

import org.agrona.concurrent.UnsafeBuffer;
import pl.zankowski.sbetest.sbe.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author Wojciech Zankowski
 */
public class Consumer {

    public static void main(String[] args) throws IOException {
        final String SYMBOL = "IBMIBM";
        final String EXCHANGE = "NYSENYSEEX";
        final String MDReqID = "0123456789";

        final MessageHeaderEncoder messageHeaderEncoder = new MessageHeaderEncoder();
        final MarketDataRequestEncoder marketDataEncoder = new MarketDataRequestEncoder();
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        final UnsafeBuffer encodeBuffer = new UnsafeBuffer(byteBuffer);
        int bufferIndex = 0;
        int length = 0;

        messageHeaderEncoder
                .wrap(encodeBuffer, bufferIndex)
                .blockLength(marketDataEncoder.sbeBlockLength())
                .templateId(marketDataEncoder.sbeTemplateId())
                .schemaId(marketDataEncoder.sbeSchemaId())
                .version(marketDataEncoder.sbeSchemaVersion());

        length += messageHeaderEncoder.encodedLength();

        marketDataEncoder
                .wrap(encodeBuffer, bufferIndex + messageHeaderEncoder.encodedLength())
                .putMDReqID(MDReqID.getBytes(), 0)
                .putSymbol(SYMBOL.getBytes(), 0)
                .putSecurityExchange(EXCHANGE.getBytes(), 0)
                .marketDepth((short) 10)
                .subscriptionRequestType(SubscriptionRequestType.SNAPSHOT_PLUS_UPDATES);

        length += marketDataEncoder.encodedLength();
        byteBuffer.limit(length);

        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.write(byteBuffer.array());

        while (true) {
            InputStream inFromServer = clientSocket.getInputStream();

            byte[] refreshMessage = new byte[1024];
            inFromServer.read(refreshMessage);
            decode(refreshMessage);
        }
    }

    private static void decode(byte[] message) {
        final MessageHeaderDecoder messageHeaderDecoder = new MessageHeaderDecoder();
        final MarketDataIncrementalRefreshTradesDecoder marketDataDecoder = new MarketDataIncrementalRefreshTradesDecoder();
        final UnsafeBuffer decoderBuffer = new UnsafeBuffer(message);

        final StringBuilder builder = new StringBuilder();

        int bufferindex = 0;

        messageHeaderDecoder.wrap(decoderBuffer, bufferindex);

        final int actingVersion = messageHeaderDecoder.version();
        final int actingBlockLength = messageHeaderDecoder.blockLength();

        marketDataDecoder.wrap(decoderBuffer, bufferindex + messageHeaderDecoder.encodedLength(), actingBlockLength, actingVersion);

        builder.append("transactTime=");
        builder.append(marketDataDecoder.transactTime());
        builder.append("#eventTimeDelta=");
        builder.append(marketDataDecoder.eventTimeDelta());
        builder.append("#matchEventIndicator=");
        builder.append(marketDataDecoder.matchEventIndicator());

        for (final MarketDataIncrementalRefreshTradesDecoder.MdIncGrpDecoder mdIncGrp : marketDataDecoder.mdIncGrp()) {
            builder.append("#tradeId=");
            builder.append(mdIncGrp.tradeId());
            builder.append("#securityId=");
            builder.append(mdIncGrp.securityId());
            builder.append("#mdEntryPx=");
            builder.append(mdIncGrp.mdEntryPx().mantissa());
            builder.append("#mdEntrySize=");
            builder.append(mdIncGrp.mdEntrySize().mantissa());
            builder.append("#numberOfOrders=");
            builder.append(mdIncGrp.numberOfOrders());
            builder.append("#mdUpdateAction=");
            builder.append(mdIncGrp.mdUpdateAction());
            builder.append("#rptSeq=");
            builder.append(mdIncGrp.rptSeq());
            builder.append("#aggressorSide=");
            builder.append(mdIncGrp.aggressorSide());
            builder.append("#mdEntryType=");
            builder.append(mdIncGrp.mdEntryType());
        }
        builder.append("\n");
        System.out.println(builder.toString());
    }

}
