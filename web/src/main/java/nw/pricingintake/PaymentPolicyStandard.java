package nw.pricingintake;

/**
 * 定价的默认处理策略。
 */
public final class PaymentPolicyStandard implements PaymentPolicy {

    @Override
    public void handle(String value) {
        VoucherResolver.collect(value);
    }
}
