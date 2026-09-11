package nw.pricingrelease;

/**
 * 定价处理策略的入口。
 */
public final class QuotePolicySelector {

    public static void prepare(String value) {
        QuotePolicy handler = attach();
        handler.handle(value);
    }

    private static QuotePolicy attach() {
        return new QuotePolicyStandard();
    }
}
