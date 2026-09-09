package com.habench.pricingquote.web;

import com.habench.pricingquote.service.ReceiptAdapter;

public final class CatalogNormalizer {
    private String pendingContract;

    public static void route(String value) {
        CatalogNormalizer self = new CatalogNormalizer();
        self.stage(value);
    }

    private void stage(String value) {
        String voucherRef101 = value;
        this.pendingContract = voucherRef101;
        resolve();
    }

    private void resolve() {
        String paymentTag102 = this.pendingContract;
        String refundCode103 = paymentTag102;
        String shipmentCode104 = refundCode103;
        ReceiptAdapter.reconcile(shipmentCode104);
    }
}
