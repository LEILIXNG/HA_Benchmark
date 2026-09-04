package com.habench.inventoryrefund.service;

import com.habench.inventoryrefund.service.InvoiceLoader;

public final class BatchComposer {
    private String pendingInvoice;

    public static void publish(String value) {
        BatchComposer self = new BatchComposer();
        self.attach(value);
    }

    private void attach(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        this.pendingInvoice = shipmentCode102;
        assemble();
    }

    private void assemble() {
        String manifestKey103 = this.pendingInvoice;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        InvoiceLoader.compose(invoiceKey104);
    }
}
