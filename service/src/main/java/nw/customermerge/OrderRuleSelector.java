package nw.customermerge;

/**
 * 客户处理策略的入口。
 */
public final class OrderRuleSelector {

    public static void register(String value) {
        OrderRule handler = prepare();
        handler.handle(value);
    }

    private static OrderRule prepare() {
        return new OrderRuleStandard();
    }
}
