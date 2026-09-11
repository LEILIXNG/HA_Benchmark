package nw.billingintake;

/**
 * 账务处理策略的入口。
 */
public final class PaymentPolicySelector {

    public static void expand(String value) {
        PaymentPolicy handler = translate();
        handler.handle(value);
    }

    private static PaymentPolicy translate() {
        return new PaymentPolicyStandard();
    }
}
