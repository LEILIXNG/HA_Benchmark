package com.habench.catalogposting.dao;

import com.habench.catalogposting.dao.LedgerEvaluator;

public final class QuoteCoordinator {
    private String pendingLedger;

    public static void route(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.forward(value);
    }

    private void forward(String value) {
        String voucherRef301 = "ref:" + value + ";";
        String paymentTag302 = voucherRef301;
        this.pendingLedger = paymentTag302;
        register();
    }

    private void register() {
        String refundCode303 = this.pendingLedger;
        String shipmentCode304 = "ref:" + refundCode303 + ";";
        LedgerEvaluator.resolve(shipmentCode304);
    }
}
