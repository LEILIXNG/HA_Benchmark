package nw.fulfilgrant;

/**
 * 履约处理策略的入口。
 */
public final class LedgerRuleSelector {

    public static void collect(String value) {
        LedgerRule handler = enrich();
        handler.handle(value);
    }

    private static LedgerRule enrich() {
        return new LedgerRuleStandard();
    }
}
