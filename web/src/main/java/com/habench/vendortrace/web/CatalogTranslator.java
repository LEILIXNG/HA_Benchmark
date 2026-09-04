package com.habench.vendortrace.web;

import com.habench.vendortrace.service.ReceiptRegistry;

public final class CatalogTranslator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void route(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.translate(value);
    }

    private void translate(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        cachedManifest = accountRef2;
        merge();
    }

    private void merge() {
        String voucherRef3 = cachedManifest;
        String paymentTag4 = voucherRef3;
        this.pendingManifest = paymentTag4;
        expand();
    }

    private void expand() {
        String refundCode5 = this.pendingManifest;
        String shipmentCode6 = "ref:" + refundCode5 + ";";
        ReceiptRegistry.refine(shipmentCode6);
    }
}
