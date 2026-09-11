package nw.pricingrelease;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchCollector {

    public static void publish(String value) {
        final String orderRef101 = value;
        QuotePolicySelector.prepare(orderRef101);
    }
}
