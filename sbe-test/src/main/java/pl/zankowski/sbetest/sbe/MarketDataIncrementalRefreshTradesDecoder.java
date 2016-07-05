/* Generated SBE (Simple Binary Encoding) message codec */
package pl.zankowski.sbetest.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

@javax.annotation.Generated(value = {"pl.zankowski.sbetest.sbe.MarketDataIncrementalRefreshTradesDecoder"})
@SuppressWarnings("all")
public class MarketDataIncrementalRefreshTradesDecoder
{
    public static final int BLOCK_LENGTH = 11;
    public static final int TEMPLATE_ID = 2;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final MarketDataIncrementalRefreshTradesDecoder parentMessage = this;
    private DirectBuffer buffer;
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
        return "X";
    }

    public int offset()
    {
        return offset;
    }

    public MarketDataIncrementalRefreshTradesDecoder wrap(
        final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

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

    public static int transactTimeId()
    {
        return 60;
    }

    public static String transactTimeMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static long transactTimeNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long transactTimeMinValue()
    {
        return 0x0L;
    }

    public static long transactTimeMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public long transactTime()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int eventTimeDeltaId()
    {
        return 37704;
    }

    public static String eventTimeDeltaMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static int eventTimeDeltaNullValue()
    {
        return 65535;
    }

    public static int eventTimeDeltaMinValue()
    {
        return 0;
    }

    public static int eventTimeDeltaMaxValue()
    {
        return 65534;
    }

    public int eventTimeDelta()
    {
        return (buffer.getShort(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    public static int matchEventIndicatorId()
    {
        return 5799;
    }

    public static String matchEventIndicatorMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public MatchEventIndicator matchEventIndicator()
    {
        return MatchEventIndicator.get(buffer.getByte(offset + 10));
    }


    private final MdIncGrpDecoder mdIncGrp = new MdIncGrpDecoder();

    public static long mdIncGrpDecoderId()
    {
        return 268;
    }

    public MdIncGrpDecoder mdIncGrp()
    {
        mdIncGrp.wrap(parentMessage, buffer);
        return mdIncGrp;
    }

    public static class MdIncGrpDecoder
        implements Iterable<MdIncGrpDecoder>, java.util.Iterator<MdIncGrpDecoder>
    {
        private static final int HEADER_SIZE = 4;
        private final GroupSizeEncodingDecoder dimensions = new GroupSizeEncodingDecoder();
        private MarketDataIncrementalRefreshTradesDecoder parentMessage;
        private DirectBuffer buffer;
        private int blockLength;
        private int actingVersion;
        private int count;
        private int index;
        private int offset;

        public void wrap(
            final MarketDataIncrementalRefreshTradesDecoder parentMessage, final DirectBuffer buffer)
        {
            this.parentMessage = parentMessage;
            this.buffer = buffer;
            dimensions.wrap(buffer, parentMessage.limit());
            blockLength = dimensions.blockLength();
            count = dimensions.numInGroup();
            index = -1;
            parentMessage.limit(parentMessage.limit() + HEADER_SIZE);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 33;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<MdIncGrpDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        public MdIncGrpDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static int tradeIdId()
        {
            return 1003;
        }

        public static String tradeIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long tradeIdNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long tradeIdMinValue()
        {
            return 0x0L;
        }

        public static long tradeIdMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long tradeId()
        {
            return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int securityIdId()
        {
            return 48;
        }

        public static String securityIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static long securityIdNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long securityIdMinValue()
        {
            return 0x0L;
        }

        public static long securityIdMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long securityId()
        {
            return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int mdEntryPxId()
        {
            return 270;
        }

        public static String mdEntryPxMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final Decimal64Decoder mdEntryPx = new Decimal64Decoder();

        public Decimal64Decoder mdEntryPx()
        {
            mdEntryPx.wrap(buffer, offset + 16);
            return mdEntryPx;
        }

        public static int mdEntrySizeId()
        {
            return 271;
        }

        public static String mdEntrySizeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        private final IntQty32Decoder mdEntrySize = new IntQty32Decoder();

        public IntQty32Decoder mdEntrySize()
        {
            mdEntrySize.wrap(buffer, offset + 24);
            return mdEntrySize;
        }

        public static int numberOfOrdersId()
        {
            return 346;
        }

        public static String numberOfOrdersMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static int numberOfOrdersNullValue()
        {
            return 65535;
        }

        public static int numberOfOrdersMinValue()
        {
            return 0;
        }

        public static int numberOfOrdersMaxValue()
        {
            return 65534;
        }

        public int numberOfOrders()
        {
            return (buffer.getShort(offset + 28, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }


        public static int mdUpdateActionId()
        {
            return 279;
        }

        public static String mdUpdateActionMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MDUpdateAction mdUpdateAction()
        {
            return MDUpdateAction.get(((short)(buffer.getByte(offset + 30) & 0xFF)));
        }


        public static int rptSeqId()
        {
            return 83;
        }

        public static String rptSeqMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public static short rptSeqNullValue()
        {
            return (short)255;
        }

        public static short rptSeqMinValue()
        {
            return (short)0;
        }

        public static short rptSeqMaxValue()
        {
            return (short)254;
        }

        public short rptSeq()
        {
            return ((short)(buffer.getByte(offset + 31) & 0xFF));
        }


        public static int aggressorSideId()
        {
            return 5797;
        }

        public static String aggressorSideMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public Side aggressorSide()
        {
            return Side.get(buffer.getByte(offset + 32));
        }


        public static int mdEntryTypeId()
        {
            return 269;
        }

        public static String mdEntryTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "unix";
                case TIME_UNIT: return "nanosecond";
                case SEMANTIC_TYPE: return "";
            }

            return "";
        }

        public MDEntryType mdEntryType()
        {
            return MDEntryType.TRADE;
        }

    }
}
