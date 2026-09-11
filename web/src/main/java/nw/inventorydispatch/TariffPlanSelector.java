package nw.inventorydispatch;

/**
 * 库存处理策略的入口。
 */
public final class TariffPlanSelector {

    public static void register(String value) {
        TariffPlan handler = translate();
        handler.handle(value);
    }

    private static TariffPlan translate() {
        return new TariffPlanStandard();
    }
}
