package nw.pricingrelease;

/**
 * 定价的默认处理策略。
 */
public final class QuotePolicyStandard implements QuotePolicy {

    @Override
    public void handle(String value) {
        BundleResolver.route(value);
    }
}
