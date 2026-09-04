package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {
    private String pendingRefund;

    public static void translate(String value) {
        BundleAdapter self = new BundleAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = catalogKey1;
        this.pendingRefund = receiptKey2;
        assemble();
    }

    private void assemble() {
        String accountRef3 = this.pendingRefund;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        InvoiceRegistry.expand(voucherRef4);
    }
}
