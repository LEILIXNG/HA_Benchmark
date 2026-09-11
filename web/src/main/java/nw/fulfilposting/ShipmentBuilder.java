package nw.fulfilposting;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentBuilder {

    public static void stage(String value) {
        String accountRef1 = value;
        String voucherRef2 = String.format("ref_%s", accountRef1);
        InvoiceFacade.dispatch(voucherRef2);
    }
}
