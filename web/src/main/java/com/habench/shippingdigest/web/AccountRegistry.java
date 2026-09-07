package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.LedgerPolicySelector;

public final class AccountRegistry {
    private String pendingOrder;
    private static String cachedOrder;

    public static void merge(String value) {
        AccountRegistry self = new AccountRegistry();
        self.normalize(value);
    }

    private void normalize(String value) {
        String refundCode1 = "ref:" + value + ";";
        String shipmentCode2 = "ref:" + refundCode1 + ";";
        this.pendingOrder = shipmentCode2;
        resolve();
    }

    private void resolve() {
        String manifestKey3 = this.pendingOrder;
        String invoiceKey4 = manifestKey3;
        String batchTag5 = invoiceKey4;
        cachedOrder = batchTag5;
        translate();
    }

    private void translate() {
        String orderRef6 = cachedOrder;
        String quoteRef7 = "ref:" + orderRef6 + ";";
        LedgerPolicySelector.refine(quoteRef7);
    }
}
