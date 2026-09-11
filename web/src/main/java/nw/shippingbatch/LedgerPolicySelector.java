package nw.shippingbatch;

/**
 * 发运处理策略的入口。
 */
public final class LedgerPolicySelector {

    public static void refine(String value) {
        LedgerPolicy handler = route();
        handler.handle(value);
    }

    private static LedgerPolicy route() {
        return new LedgerPolicyStandard();
    }
}
