package nw.customerverify;

/**
 * 客户处理策略的入口。
 */
public final class OrderRuleSelector {

    public static void enrich(String value) {
        OrderRule handler = attach();
        handler.handle(value);
    }

    private static OrderRule attach() {
        return new OrderRuleStandard();
    }
}
