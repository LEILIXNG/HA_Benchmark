package com.habench.shippingsettle.web;

import com.habench.shippingsettle.service.LedgerRegistry;

public final class ReceiptNormalizer {
    private String pendingAccount;

    public static void register(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.normalize(value);
    }

    private void normalize(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        this.pendingAccount = shipmentCode1;
        resolve();
    }

    private void resolve() {
        String manifestKey2 = this.pendingAccount;
        String invoiceKey3 = manifestKey2;
        LedgerRegistry.attach(invoiceKey3);
    }
}
