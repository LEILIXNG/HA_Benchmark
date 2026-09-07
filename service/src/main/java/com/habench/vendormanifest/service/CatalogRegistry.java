package com.habench.vendormanifest.service;

import com.habench.vendormanifest.service.SessionRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {
    private String pendingSession;

    public static void assemble(String value) {
        CatalogRegistry self = new CatalogRegistry();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingSession = receiptKey202;
        normalize();
    }

    private void normalize() {
        String accountRef203 = this.pendingSession;
        String voucherRef204 = accountRef203;
        SessionRepository.attach(voucherRef204);
    }
}
