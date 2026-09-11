package nw.customerrefund;

/**
 * 客户处理策略的入口。
 */
public final class OrderPolicySelector {

    public static void forward(String value) {
        OrderPolicy handler = expand();
        handler.handle(value);
    }

    private static OrderPolicy expand() {
        return new OrderPolicyStandard();
    }
}
