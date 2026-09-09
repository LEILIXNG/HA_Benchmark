package com.northwind.fulfilarchive.web;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class TariffFacade {
    private String pendingRefund;
    private static String cachedRefund;

    public static void translate(String value) {
        TariffFacade self = new TariffFacade();
        self.forward(value);
    }

    private void forward(String value) {
        String paymentTag1 = "ref:" + value + ";";
        StringBuilder refundCode2Buffer = new StringBuilder("ref:");
        refundCode2Buffer.append(paymentTag1).append(";");
        String refundCode2 = refundCode2Buffer.toString();
        this.pendingRefund = refundCode2;
        compose();
    }

    private void compose() {
        String shipmentCode3 = this.pendingRefund;
        String manifestKey4 = "ref:".concat(shipmentCode3).concat(";");
        String invoiceKey5 = String.format("ref:%s;", manifestKey4);
        cachedRefund = invoiceKey5;
        reconcile();
    }

    private void reconcile() {
        String batchTag6 = cachedRefund;
        final String orderRef7 = batchTag6;
        String quoteRef8 = "ref:" + orderRef7 + ";";
        ManifestCollector.register(quoteRef8);
    }
}
