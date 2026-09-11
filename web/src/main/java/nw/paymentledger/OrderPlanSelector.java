package nw.paymentledger;

/**
 * 支付处理策略的入口。
 */
public final class OrderPlanSelector {

    public static void translate(String value) {
        OrderPlan handler = merge();
        handler.handle(value);
    }

    private static OrderPlan merge() {
        return new OrderPlanStandard();
    }
}
