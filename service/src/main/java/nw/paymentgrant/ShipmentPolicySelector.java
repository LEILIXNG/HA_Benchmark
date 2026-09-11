package nw.paymentgrant;

/**
 * 支付处理策略的入口。
 */
public final class ShipmentPolicySelector {

    public static void assemble(String value) {
        ShipmentPolicy handler = prepare();
        handler.handle(value);
    }

    private static ShipmentPolicy prepare() {
        return new ShipmentPolicyStandard();
    }
}
