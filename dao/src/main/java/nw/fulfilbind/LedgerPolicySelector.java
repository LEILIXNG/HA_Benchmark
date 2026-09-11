package nw.fulfilbind;

/**
 * 履约处理策略的入口。
 */
public final class LedgerPolicySelector {

    public static void resolve(String value) {
        LedgerPolicy handler = normalize();
        handler.handle(value);
    }

    private static LedgerPolicy normalize() {
        return new LedgerPolicyStandard();
    }
}
