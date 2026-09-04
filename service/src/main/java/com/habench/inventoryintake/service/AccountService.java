package com.habench.inventoryintake.service;

import com.habench.inventoryintake.service.InvoiceRouter;

public final class AccountService {
    private String pendingPayment;

    public static void compose(String value) {
        AccountService self = new AccountService();
        self.attach(value);
    }

    private void attach(String value) {
        String batchTag301 = value;
        String orderRef302 = "ref:" + batchTag301 + ";";
        this.pendingPayment = orderRef302;
        register();
    }

    private void register() {
        String quoteRef303 = this.pendingPayment;
        String tariffRef304 = "ref:" + quoteRef303 + ";";
        String ledgerEntry305 = tariffRef304;
        InvoiceRouter.register(ledgerEntry305);
    }
}
