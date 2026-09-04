package com.habench.accountissue.web;

import com.habench.accountissue.service.AccountCoordinator;

public final class InvoiceAdapter {
    private String pendingRefund;

    public static void collect(String value) {
        InvoiceAdapter self = new InvoiceAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        this.pendingRefund = shipmentCode1;
        forward();
    }

    private void forward() {
        String manifestKey2 = this.pendingRefund;
        String invoiceKey3 = manifestKey2;
        AccountCoordinator.enrich(invoiceKey3);
    }
}
