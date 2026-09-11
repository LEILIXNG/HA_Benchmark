package nw.billingtrace;

/**
 * 账务处理策略的入口。
 */
public final class OrderPlanSelector {

    public static void translate(String value) {
        OrderPlan handler = stage();
        handler.handle(value);
    }

    private static OrderPlan stage() {
        return new OrderPlanStandard();
    }
}
