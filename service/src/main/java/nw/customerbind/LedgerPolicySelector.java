package nw.customerbind;

/**
 * 客户处理策略的入口。
 */
public final class LedgerPolicySelector {

    public static void reconcile(String value) {
        LedgerPolicy handler = resolve();
        handler.handle(value);
    }

    private static LedgerPolicy resolve() {
        return new LedgerPolicyStandard();
    }
}
