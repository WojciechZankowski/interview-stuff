/* Generated SBE (Simple Binary Encoding) message codec */
package pl.zankowski.sbetest.sbe;

@javax.annotation.Generated(value = {"pl.zankowski.sbetest.sbe.SubscriptionRequestType"})
public enum SubscriptionRequestType
{
    SNAPSHOT((byte)48),
    SNAPSHOT_PLUS_UPDATES((byte)49),
    DISABLE_SNAPSHOT((byte)50),
    NULL_VAL((byte)0);

    private final byte value;

    SubscriptionRequestType(final byte value)
    {
        this.value = value;
    }

    public byte value()
    {
        return value;
    }

    public static SubscriptionRequestType get(final byte value)
    {
        switch (value)
        {
            case 48: return SNAPSHOT;
            case 49: return SNAPSHOT_PLUS_UPDATES;
            case 50: return DISABLE_SNAPSHOT;
        }

        if ((byte)0 == value)
        {
            return NULL_VAL;
        }

        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
