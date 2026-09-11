package nw.accountreopen;

/**
 * 账户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ReceiptEnricher {
    private static String cachedSession;

    public static void enrich(String value) {
        String voucherRef101 = new StringBuilder(value).toString();
        cachedSession = voucherRef101;
        route();
    }

    private static void route() {
        String paymentTag102 = cachedSession;
        String refundCode103 = "ref_" + paymentTag102;
        cachedSession = refundCode103;
        refine();
    }

    private static void refine() {
        String shipmentCode104 = cachedSession;
        String manifestKey105 = String.format("ref_%s", shipmentCode104);
        ShipmentAssembler.assemble(manifestKey105);
    }
}
