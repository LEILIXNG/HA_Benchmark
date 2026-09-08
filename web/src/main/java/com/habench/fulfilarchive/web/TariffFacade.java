package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.ManifestCollector;

public final class TariffFacade {
    private String pendingRefund;
    private static String cachedRefund;

    public static void translate(String value) {
        TariffFacade self = new TariffFacade();
        self.forward(value);
    }

    private void forward(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = "ref:" + paymentTag1 + ";";
        this.pendingRefund = refundCode2;
        compose();
    }

    private void compose() {
        String shipmentCode3 = this.pendingRefund;
        String manifestKey4 = "ref:" + shipmentCode3 + ";";
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        cachedRefund = invoiceKey5;
        reconcile();
    }

    private void reconcile() {
        String batchTag6 = cachedRefund;
        String orderRef7 = batchTag6;
        String quoteRef8 = "ref:" + orderRef7 + ";";
        ManifestCollector.register(quoteRef8);
    }
}
