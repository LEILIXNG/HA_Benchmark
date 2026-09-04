package com.habench.shippingarchive.service;

import com.habench.shippingarchive.dao.ShipmentCoordinator;

public final class VoucherEnricher {
    private String pendingSession;

    public static void submit(String value) {
        VoucherEnricher self = new VoucherEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        String catalogKey201 = value;
        String receiptKey202 = catalogKey201;
        this.pendingSession = receiptKey202;
        merge();
    }

    private void merge() {
        String accountRef203 = this.pendingSession;
        String voucherRef204 = accountRef203;
        ShipmentCoordinator.dispatch(voucherRef204);
    }
}
