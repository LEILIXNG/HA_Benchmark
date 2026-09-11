package nw.catalogexport;

/**
 * 商品处理策略的入口。
 */
public final class LedgerRuleSelector {

    public static void resolve(String value) {
        LedgerRule handler = normalize();
        handler.handle(value);
    }

    private static LedgerRule normalize() {
        return new LedgerRuleStandard();
    }
}
