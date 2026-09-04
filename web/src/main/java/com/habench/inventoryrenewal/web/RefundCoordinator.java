package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.LedgerLoader;

public final class RefundCoordinator {
    private String pendingLedger;

    public static void expand(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String accountRef101 = value;
        String voucherRef102 = "ref:" + accountRef101 + ";";
        this.pendingLedger = voucherRef102;
        compose();
    }

    private void compose() {
        String paymentTag103 = this.pendingLedger;
        String refundCode104 = "ref:" + paymentTag103 + ";";
        String shipmentCode105 = refundCode104;
        LedgerLoader.route(shipmentCode105);
    }
}
