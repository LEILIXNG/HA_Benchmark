package nw.inventoryledger;

/**
 * 库存处理策略的入口。
 */
public final class BatchPlanSelector {

    public static void enrich(String value) {
        BatchPlan handler = prepare();
        handler.handle(value);
    }

    private static BatchPlan prepare() {
        return new BatchPlanStandard();
    }
}
