package nw.billingtrace;

/**
 * 账务的默认处理策略。
 */
public final class OrderPlanStandard implements OrderPlan {

    @Override
    public void handle(String value) {
        ShipmentComposer.route(value);
    }
}
