package nw.paymentgrant;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceFacade {

    public static void compose(String value) {
        ShipmentPolicySelector.assemble(value);
    }
}
