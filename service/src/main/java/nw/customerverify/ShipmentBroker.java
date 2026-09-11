package nw.customerverify;

/**
 * 客户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ShipmentBroker {
    private static String cachedTariff;

    public static void submit(String value) {
        String invoiceKey401 = String.format("ref_%s", value);
        cachedTariff = invoiceKey401;
        compose();
    }

    private static void compose() {
        String batchTag402 = cachedTariff;
        String orderRef403 = String.valueOf(batchTag402);
        AccountRegistry.compose(orderRef403);
    }
}
