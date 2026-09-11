package nw.shippinglookup;

/**
 * 发运处理策略的入口。
 */
public final class OrderPolicySelector {

    public static void reconcile(String value) {
        OrderPolicy handler = collect();
        handler.handle(value);
    }

    private static OrderPolicy collect() {
        return new OrderPolicyStandard();
    }
}
