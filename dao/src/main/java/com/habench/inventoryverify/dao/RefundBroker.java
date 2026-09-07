package com.habench.inventoryverify.dao;

import com.habench.inventoryverify.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingManifest;

    public static void register(String value) {
        RefundBroker self = new RefundBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingManifest = receiptKey202;
        enrich();
    }

    private void enrich() {
        String accountRef203 = this.pendingManifest;
        String voucherRef204 = accountRef203;
        RefundComposer.submit(voucherRef204);
    }
}
