package nw.shippinggrant;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherCoordinator {

    public static void compose(String value) {
        String invoiceKey301 = "ref_".concat(value);
        RefundComposer.translate(invoiceKey301);
    }
}
