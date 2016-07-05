/* Generated SBE (Simple Binary Encoding) message codec */
package pl.zankowski.sbetest.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

@javax.annotation.Generated(value = {"pl.zankowski.sbetest.sbe.MarketDataRequestEncoder"})
@SuppressWarnings("all")
public class MarketDataRequestEncoder
{
    public static final int BLOCK_LENGTH = 36;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataRequestEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public int offset()
    {
        return offset;
    }

    public MarketDataRequestEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);
        return this;
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static byte mDReqIDNullValue()
    {
        return (byte)0;
    }

    public static byte mDReqIDMinValue()
    {
        return (byte)32;
    }

    public static byte mDReqIDMaxValue()
    {
        return (byte)126;
    }

    public static int mDReqIDLength()
    {
        return 10;
    }

    public void mDReqID(final int index, final byte value)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 0 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String mDReqIDCharacterEncoding()
    {
        return "UTF-8";
    }
    public MarketDataRequestEncoder putMDReqID(final byte[] src, final int srcOffset)
    {
        final int length = 10;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 0, src, srcOffset, length);

        return this;
    }
    public MarketDataRequestEncoder subscriptionRequestType(final SubscriptionRequestType value)
    {
        buffer.putByte(offset + 10, value.value());
        return this;
    }

    public static short marketDepthNullValue()
    {
        return (short)255;
    }

    public static short marketDepthMinValue()
    {
        return (short)0;
    }

    public static short marketDepthMaxValue()
    {
        return (short)254;
    }

    public MarketDataRequestEncoder marketDepth(final short value)
    {
        buffer.putByte(offset + 11, (byte)value);
        return this;
    }


    public static byte symbolNullValue()
    {
        return (byte)0;
    }

    public static byte symbolMinValue()
    {
        return (byte)32;
    }

    public static byte symbolMaxValue()
    {
        return (byte)126;
    }

    public static int symbolLength()
    {
        return 6;
    }

    public void symbol(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 12 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String symbolCharacterEncoding()
    {
        return "UTF-8";
    }
    public MarketDataRequestEncoder putSymbol(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 12, src, srcOffset, length);

        return this;
    }

    public static byte securityExchangeNullValue()
    {
        return (byte)0;
    }

    public static byte securityExchangeMinValue()
    {
        return (byte)32;
    }

    public static byte securityExchangeMaxValue()
    {
        return (byte)126;
    }

    public static int securityExchangeLength()
    {
        return 10;
    }

    public void securityExchange(final int index, final byte value)
    {
        if (index < 0 || index >= 10)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 18 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String securityExchangeCharacterEncoding()
    {
        return "UTF-8";
    }
    public MarketDataRequestEncoder putSecurityExchange(final byte[] src, final int srcOffset)
    {
        final int length = 10;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 18, src, srcOffset, length);

        return this;
    }

    public static byte cFICodeNullValue()
    {
        return (byte)0;
    }

    public static byte cFICodeMinValue()
    {
        return (byte)32;
    }

    public static byte cFICodeMaxValue()
    {
        return (byte)126;
    }

    public static int cFICodeLength()
    {
        return 6;
    }

    public void cFICode(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 28 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String cFICodeCharacterEncoding()
    {
        return "UTF-8";
    }
    public MarketDataRequestEncoder putCFICode(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 28, src, srcOffset, length);

        return this;
    }

    public static int maturityDateNullValue()
    {
        return 65535;
    }

    public static int maturityDateMinValue()
    {
        return 0;
    }

    public static int maturityDateMaxValue()
    {
        return 65534;
    }

    public MarketDataRequestEncoder maturityDate(final int value)
    {
        buffer.putShort(offset + 34, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

}
