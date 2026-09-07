package com.habench.customerdispatch.service;

import com.habench.customerdispatch.service.QuotePlanSelector;

public final class CatalogComposer {
    private String pendingBundle;
    private static String cachedBundle;

    public static void forward(String value) {
        CatalogComposer self = new CatalogComposer();
        self.assemble(value);
    }

    private void assemble(String value) {
        String voucherRef101 = value;
        String paymentTag102 = voucherRef101;
        cachedBundle = paymentTag102;
        translate();
    }

    private void translate() {
        String refundCode103 = cachedBundle;
        String shipmentCode104 = refundCode103;
        this.pendingBundle = shipmentCode104;
        route();
    }

    private void route() {
        String manifestKey105 = this.pendingBundle;
        String invoiceKey106 = manifestKey105;
        cachedBundle = invoiceKey106;
        compose();
    }

    private void compose() {
        String batchTag107 = cachedBundle;
        String orderRef108 = batchTag107;
        String quoteRef109 = "ref:" + orderRef108 + ";";
        cachedBundle = quoteRef109;
        stage();
    }

    private void stage() {
        String tariffRef110 = cachedBundle;
        String ledgerEntry111 = "ref:" + tariffRef110 + ";";
        String channelTag112 = ledgerEntry111;
        QuotePlanSelector.stage(channelTag112);
    }
}
