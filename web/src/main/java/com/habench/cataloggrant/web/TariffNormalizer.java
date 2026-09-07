package com.habench.cataloggrant.web;

import com.habench.cataloggrant.web.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {
    private String pendingManifest;
    private static String cachedManifest;

    public static void expand(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String tariffRef1 = value;
        cachedManifest = tariffRef1;
        register();
    }

    private void register() {
        String ledgerEntry2 = cachedManifest;
        String channelTag3 = ledgerEntry2;
        this.pendingManifest = channelTag3;
        enrich();
    }

    private void enrich() {
        String catalogKey4 = this.pendingManifest;
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        RefundBroker.attach(receiptKey5);
    }
}
