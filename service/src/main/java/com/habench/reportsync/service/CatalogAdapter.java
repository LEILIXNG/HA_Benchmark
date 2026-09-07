package com.habench.reportsync.service;

import com.habench.reportsync.service.QuotePlanSelector;

public final class CatalogAdapter {
    private String pendingRefund;

    public static void expand(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String paymentTag101 = "ref:" + value + ";";
        String refundCode102 = "ref:" + paymentTag101 + ";";
        this.pendingRefund = refundCode102;
        refine();
    }

    private void refine() {
        String shipmentCode103 = this.pendingRefund;
        String manifestKey104 = shipmentCode103;
        QuotePlanSelector.expand(manifestKey104);
    }
}
