package nw.billingrollup;

/**
 * 账务处理策略的入口。
 */
public final class LedgerRuleSelector {

    public static void route(String value) {
        LedgerRule handler = stage();
        handler.handle(value);
    }

    private static LedgerRule stage() {
        return new LedgerRuleStandard();
    }
}
