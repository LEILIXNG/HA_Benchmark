package nw.reportsettle;

/**
 * 报表受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentEnricher {
    private static String cachedChannel;

    public static void submit(String value) {
        StringBuilder refundCode1Buffer = new StringBuilder("ref_");
        refundCode1Buffer.append(value);
        String refundCode1 = refundCode1Buffer.toString();
        final String shipmentCode2 = refundCode1;
        cachedChannel = shipmentCode2;
        assemble();
    }

    private static void assemble() {
        String manifestKey3 = cachedChannel;
        String invoiceKey4 = manifestKey3;
        String batchTag5 = "ref_".concat(invoiceKey4);
        VoucherCollector.prepare(batchTag5);
    }
}
