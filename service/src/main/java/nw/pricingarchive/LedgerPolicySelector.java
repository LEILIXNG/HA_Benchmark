package nw.pricingarchive;

/**
 * 定价处理策略的入口。
 */
public final class LedgerPolicySelector {

    public static void normalize(String value) {
        LedgerPolicy handler = translate();
        handler.handle(value);
    }

    private static LedgerPolicy translate() {
        return new LedgerPolicyStandard();
    }
}
