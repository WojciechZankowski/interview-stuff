/* Generated SBE (Simple Binary Encoding) message codec */
package pl.zankowski.sbetest.sbe;

import org.agrona.DirectBuffer;

@javax.annotation.Generated(value = {"pl.zankowski.sbetest.sbe.Decimal64Decoder"})
@SuppressWarnings("all")
public class Decimal64Decoder
{
    public static final int ENCODED_LENGTH = 8;
    private DirectBuffer buffer;
    private int offset;

    public Decimal64Decoder wrap(final DirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        return this;
    }

    public int encodedLength()
    {
        return ENCODED_LENGTH;
    }

    public static long mantissaNullValue()
    {
        return -9223372036854775808L;
    }

    public static long mantissaMinValue()
    {
        return -9223372036854775807L;
    }

    public static long mantissaMaxValue()
    {
        return 9223372036854775807L;
    }

    public long mantissa()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static byte exponentNullValue()
    {
        return (byte)-128;
    }

    public static byte exponentMinValue()
    {
        return (byte)-127;
    }

    public static byte exponentMaxValue()
    {
        return (byte)127;
    }

    public byte exponent()
    {
        return (byte)7;
    }
}
