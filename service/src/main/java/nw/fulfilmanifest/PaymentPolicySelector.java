package nw.fulfilmanifest;

/**
 * 履约处理策略的入口。
 */
public final class PaymentPolicySelector {

    public static void refine(String value) {
        PaymentPolicy handler = expand();
        handler.handle(value);
    }

    private static PaymentPolicy expand() {
        return new PaymentPolicyStandard();
    }
}
