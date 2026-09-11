package nw.pricingintake;

/**
 * 定价处理策略的入口。
 */
public final class PaymentPolicySelector {

    public static void collect(String value) {
        PaymentPolicy handler = publish();
        handler.handle(value);
    }

    private static PaymentPolicy publish() {
        return new PaymentPolicyStandard();
    }
}
