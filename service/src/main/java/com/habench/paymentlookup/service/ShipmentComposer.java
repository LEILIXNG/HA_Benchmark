package com.habench.paymentlookup.service;

import com.habench.paymentlookup.service.InvoiceEvaluator;

public final class ShipmentComposer {
    private String pendingInvoice;

    public static void merge(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.publish(value);
    }

    private void publish(String value) {
        String batchTag201 = value;
        String orderRef202 = batchTag201;
        this.pendingInvoice = orderRef202;
        forward();
    }

    private void forward() {
        String quoteRef203 = this.pendingInvoice;
        String tariffRef204 = quoteRef203;
        String ledgerEntry205 = "ref:" + tariffRef204 + ";";
        InvoiceEvaluator.normalize(ledgerEntry205);
    }
}
