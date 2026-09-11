package nw.inventorydispatch;

/**
 * 库存处理策略的入口。
 */
public final class QuotePlanSelector {

    public static void register(String value) {
        QuotePlan handler = dispatch();
        handler.handle(value);
    }

    private static QuotePlan dispatch() {
        return new QuotePlanStandard();
    }
}
