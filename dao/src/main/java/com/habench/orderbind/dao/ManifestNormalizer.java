package com.habench.orderbind.dao;

import com.habench.orderbind.dao.BatchEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private String pendingBatch;

    public static void collect(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        String channelTag302 = ledgerEntry301;
        this.pendingBatch = channelTag302;
        register();
    }

    private void register() {
        String catalogKey303 = this.pendingBatch;
        String receiptKey304 = catalogKey303;
        String accountRef305 = receiptKey304;
        BatchEvaluator.expand(accountRef305);
    }
}
