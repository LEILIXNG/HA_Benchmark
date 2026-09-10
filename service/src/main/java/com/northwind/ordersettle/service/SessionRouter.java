package com.northwind.ordersettle.service;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class SessionRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void merge(String value) {
        SessionRouter self = new SessionRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String invoiceKey101 = new StringBuilder(value).toString();
        String batchTag102 = "ref_".concat(invoiceKey101);
        this.pendingShipment = batchTag102;
        register();
    }

    private void register() {
        String orderRef103 = this.pendingShipment;
        StringBuilder quoteRef104Buffer = new StringBuilder("ref_");
        quoteRef104Buffer.append(orderRef103);
        String quoteRef104 = quoteRef104Buffer.toString();
        cachedShipment = quoteRef104;
        resolve();
    }

    private void resolve() {
        String tariffRef105 = cachedShipment;
        String ledgerEntry106 = tariffRef105;
        String channelTag107 = "ref_" + ledgerEntry106;
        ChannelValidator.assemble(channelTag107);
    }
}
