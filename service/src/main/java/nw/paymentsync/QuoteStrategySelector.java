package nw.paymentsync;

/**
 * 支付处理策略的入口。
 */
public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = reconcile();
        handler.handle(value);
    }

    private static QuoteStrategy reconcile() {
        return new QuoteStrategyStandard();
    }
}
