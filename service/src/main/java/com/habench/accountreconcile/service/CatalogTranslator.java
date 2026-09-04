package com.habench.accountreconcile.service;

import com.habench.accountreconcile.service.SessionAdapter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private String pendingBatch;

    public static void assemble(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = ledgerEntry201;
        this.pendingBatch = channelTag202;
        reconcile();
    }

    private void reconcile() {
        String catalogKey203 = this.pendingBatch;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        this.pendingBatch = receiptKey204;
        stage();
    }

    private void stage() {
        String accountRef205 = this.pendingBatch;
        String voucherRef206 = accountRef205;
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        SessionAdapter.reconcile(paymentTag207);
    }
}
