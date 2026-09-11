package nw.fulfilquote;

/**
 * 履约处理策略的入口。
 */
public final class QuotePlanSelector {

    public static void translate(String value) {
        QuotePlan handler = route();
        handler.handle(value);
    }

    private static QuotePlan route() {
        return new QuotePlanStandard();
    }
}
