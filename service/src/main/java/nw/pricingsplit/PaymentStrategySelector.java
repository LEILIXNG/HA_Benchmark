package nw.pricingsplit;

/**
 * 定价处理策略的入口。
 */
public final class PaymentStrategySelector {

    public static void collect(String value) {
        PaymentStrategy handler = forward();
        handler.handle(value);
    }

    private static PaymentStrategy forward() {
        return new PaymentStrategyStandard();
    }
}
