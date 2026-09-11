package nw.billingintake;

/**
 * 账务的默认处理策略。
 */
public final class PaymentPolicyStandard implements PaymentPolicy {

    @Override
    public void handle(String value) {
        QuoteCoordinator.prepare(value);
    }
}
