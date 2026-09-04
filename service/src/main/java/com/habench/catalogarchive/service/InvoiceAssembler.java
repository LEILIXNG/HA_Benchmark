package com.habench.catalogarchive.service;

import com.habench.catalogarchive.dao.VoucherRouter;

public final class InvoiceAssembler {
    private String pendingShipment;

    public static void compose(String value) {
        InvoiceAssembler self = new InvoiceAssembler();
        self.collect(value);
    }

    private void collect(String value) {
        String paymentTag201 = "ref:" + value + ";";
        this.pendingShipment = paymentTag201;
        stage();
    }

    private void stage() {
        String refundCode202 = this.pendingShipment;
        String shipmentCode203 = refundCode202;
        String manifestKey204 = shipmentCode203;
        VoucherRouter.compose(manifestKey204);
    }
}
