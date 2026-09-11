package nw.paymentledger;

/**
 * 支付的默认处理策略。
 */
public final class OrderPlanStandard implements OrderPlan {

    @Override
    public void handle(String value) {
        ShipmentResolver.refine(value);
    }
}
