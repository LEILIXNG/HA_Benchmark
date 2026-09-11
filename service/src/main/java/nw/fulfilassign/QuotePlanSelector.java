package nw.fulfilassign;

/**
 * 履约处理策略的入口。
 */
public final class QuotePlanSelector {

    public static void expand(String value) {
        QuotePlan handler = reconcile();
        handler.handle(value);
    }

    private static QuotePlan reconcile() {
        return new QuotePlanStandard();
    }
}
