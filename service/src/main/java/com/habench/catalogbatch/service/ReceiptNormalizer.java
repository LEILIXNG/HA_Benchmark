package com.habench.catalogbatch.service;

import com.habench.catalogbatch.dao.ReceiptCoordinator;

public final class ReceiptNormalizer {
    private String pendingAccount;

    public static void register(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.forward(value);
    }

    private void forward(String value) {
        String catalogKey101 = "ref:" + value + ";";
        this.pendingAccount = catalogKey101;
        assemble();
    }

    private void assemble() {
        String receiptKey102 = this.pendingAccount;
        String accountRef103 = receiptKey102;
        String voucherRef104 = accountRef103;
        ReceiptCoordinator.translate(voucherRef104);
    }
}
