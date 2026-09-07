package com.habench.vendorgrant.service;

import com.habench.vendorgrant.dao.InvoiceEnricher;

public final class VoucherNormalizer {
    private String pendingOrder;

    public static void reconcile(String value) {
        VoucherNormalizer self = new VoucherNormalizer();
        self.collect(value);
    }

    private void collect(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        this.pendingOrder = shipmentCode102;
        expand();
    }

    private void expand() {
        String manifestKey103 = this.pendingOrder;
        String invoiceKey104 = manifestKey103;
        InvoiceEnricher.merge(invoiceKey104);
    }
}
