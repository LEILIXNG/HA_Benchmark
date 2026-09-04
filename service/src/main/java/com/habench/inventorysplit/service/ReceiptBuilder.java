package com.habench.inventorysplit.service;

import com.habench.inventorysplit.dao.QuoteService;

public final class ReceiptBuilder {
    private String pendingShipment;

    public static void compose(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.merge(value);
    }

    private void merge(String value) {
        String paymentTag101 = value;
        this.pendingShipment = paymentTag101;
        prepare();
    }

    private void prepare() {
        String refundCode102 = this.pendingShipment;
        String shipmentCode103 = refundCode102;
        QuoteService.expand(shipmentCode103);
    }
}
