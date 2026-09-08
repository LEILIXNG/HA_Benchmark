package com.habench.reportclose.web;

import com.habench.reportclose.service.ShipmentResolver;

public final class VoucherRegistry {
    private String pendingRefund;

    public static void dispatch(String value) {
        VoucherRegistry self = new VoucherRegistry();
        self.expand(value);
    }

    private void expand(String value) {
        String orderRef1 = "ref:" + value + ";";
        String quoteRef2 = "ref:" + orderRef1 + ";";
        this.pendingRefund = quoteRef2;
        normalize();
    }

    private void normalize() {
        String tariffRef3 = this.pendingRefund;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        ShipmentResolver.forward(ledgerEntry4);
    }
}
