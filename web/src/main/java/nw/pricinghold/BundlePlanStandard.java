package nw.pricinghold;

/**
 * 定价的默认处理策略。
 */
public final class BundlePlanStandard implements BundlePlan {

    @Override
    public void handle(String value) {
        PaymentNormalizer.route(value);
    }
}
