package nw.customerledger;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractAssembler {
    private static String cachedShipment;

    public static void prepare(String value) {
        StringBuilder refundCode301Buffer = new StringBuilder("ref_");
        refundCode301Buffer.append(value);
        String refundCode301 = refundCode301Buffer.toString();
        cachedShipment = refundCode301;
        refine();
    }

    private static void refine() {
        String shipmentCode302 = cachedShipment;
        String manifestKey303 = shipmentCode302;
        String invoiceKey304 = new StringBuilder(manifestKey303).toString();
        ShipmentFetcher.attach(invoiceKey304);
    }
}
