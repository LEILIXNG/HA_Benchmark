package com.habench.catalogdigest.web;

import com.habench.catalogdigest.service.OrderService;

public final class AccountComposer {
    private String pendingRefund;

    public static void enrich(String value) {
        AccountComposer self = new AccountComposer();
        self.route(value);
    }

    private void route(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        this.pendingRefund = receiptKey202;
        register();
    }

    private void register() {
        String accountRef203 = this.pendingRefund;
        String voucherRef204 = accountRef203;
        OrderService.publish(voucherRef204);
    }
}
