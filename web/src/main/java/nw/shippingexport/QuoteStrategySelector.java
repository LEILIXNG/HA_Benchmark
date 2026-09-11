package nw.shippingexport;

/**
 * 发运处理策略的入口。
 */
public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = attach();
        handler.handle(value);
    }

    private static QuoteStrategy attach() {
        return new QuoteStrategyStandard();
    }
}
