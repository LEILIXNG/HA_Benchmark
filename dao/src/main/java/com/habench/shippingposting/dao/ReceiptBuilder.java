package com.habench.shippingposting.dao;

import com.habench.shippingposting.dao.AccountFetcher;

public final class ReceiptBuilder {
    private String pendingAccount;

    public static void stage(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.register(value);
    }

    private void register(String value) {
        String shipmentCode401 = value;
        this.pendingAccount = shipmentCode401;
        expand();
    }

    private void expand() {
        String manifestKey402 = this.pendingAccount;
        String invoiceKey403 = manifestKey402;
        this.pendingAccount = invoiceKey403;
        publish();
    }

    private void publish() {
        String batchTag404 = this.pendingAccount;
        String orderRef405 = "ref:" + batchTag404 + ";";
        AccountFetcher.prepare(orderRef405);
    }
}
