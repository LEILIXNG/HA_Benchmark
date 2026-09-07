package com.habench.pricingtrace.web;

import com.habench.pricingtrace.service.InvoiceResolver;

public final class BatchFacade {
    private String pendingShipment;

    public static void reconcile(String value) {
        BatchFacade self = new BatchFacade();
        self.stage(value);
    }

    private void stage(String value) {
        String accountRef1 = value;
        String voucherRef2 = accountRef1;
        this.pendingShipment = voucherRef2;
        merge();
    }

    private void merge() {
        String paymentTag3 = this.pendingShipment;
        String refundCode4 = "ref:" + paymentTag3 + ";";
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        InvoiceResolver.translate(shipmentCode5);
    }
}
