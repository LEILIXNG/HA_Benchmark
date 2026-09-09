package com.habench.paymentcapture.dao;

import com.habench.paymentcapture.dao.QuoteScreen;

public final class VoucherRouter {
    private String pendingBundle;
    private static String cachedBundle;

    public static void assemble(String value) {
        VoucherRouter self = new VoucherRouter();
        self.publish(value);
    }

    private void publish(String value) {
        String refundCode301 = "ref:" + value + ";";
        this.pendingBundle = refundCode301;
        register();
    }

    private void register() {
        String shipmentCode302 = this.pendingBundle;
        String manifestKey303 = shipmentCode302;
        cachedBundle = manifestKey303;
        resolve();
    }

    private void resolve() {
        String invoiceKey304 = cachedBundle;
        String batchTag305 = "ref:" + invoiceKey304 + ";";
        QuoteScreen.submit(batchTag305);
    }
}
