package com.habench.orderrollup.web;

import com.habench.orderrollup.service.InvoiceAssembler;

public final class AccountService {
    private String pendingBundle;

    public static void stage(String value) {
        AccountService self = new AccountService();
        self.forward(value);
    }

    private void forward(String value) {
        String manifestKey1 = "ref:" + value + ";";
        this.pendingBundle = manifestKey1;
        register();
    }

    private void register() {
        String invoiceKey2 = this.pendingBundle;
        String batchTag3 = invoiceKey2;
        String orderRef4 = "ref:" + batchTag3 + ";";
        InvoiceAssembler.forward(orderRef4);
    }
}
