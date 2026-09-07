package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.service.ManifestRouter;

public final class ManifestService {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void assemble(String value) {
        ManifestService self = new ManifestService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = catalogKey1;
        this.pendingCatalog = receiptKey2;
        compose();
    }

    private void compose() {
        String accountRef3 = this.pendingCatalog;
        String voucherRef4 = accountRef3;
        cachedCatalog = voucherRef4;
        expand();
    }

    private void expand() {
        String paymentTag5 = cachedCatalog;
        String refundCode6 = paymentTag5;
        cachedCatalog = refundCode6;
        refine();
    }

    private void refine() {
        String shipmentCode7 = cachedCatalog;
        String manifestKey8 = "ref:" + shipmentCode7 + ";";
        cachedCatalog = manifestKey8;
        register();
    }

    private void register() {
        String invoiceKey9 = cachedCatalog;
        String batchTag10 = "ref:" + invoiceKey9 + ";";
        String orderRef11 = "ref:" + batchTag10 + ";";
        this.pendingCatalog = orderRef11;
        forward();
    }

    private void forward() {
        String quoteRef12 = this.pendingCatalog;
        String tariffRef13 = "ref:" + quoteRef12 + ";";
        ManifestRouter.forward(tariffRef13);
    }
}
