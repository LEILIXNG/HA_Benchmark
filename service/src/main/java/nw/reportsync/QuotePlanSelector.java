package nw.reportsync;

/**
 * 报表处理策略的入口。
 */
public final class QuotePlanSelector {

    public static void expand(String value) {
        QuotePlan handler = assemble();
        handler.handle(value);
    }

    private static QuotePlan assemble() {
        return new QuotePlanStandard();
    }
}
