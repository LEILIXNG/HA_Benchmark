package nw.inventoryreview;

/**
 * 库存处理策略的入口。
 */
public final class ShipmentPlanSelector {

    public static void publish(String value) {
        ShipmentPlan handler = attach();
        handler.handle(value);
    }

    private static ShipmentPlan attach() {
        return new ShipmentPlanStandard();
    }
}
