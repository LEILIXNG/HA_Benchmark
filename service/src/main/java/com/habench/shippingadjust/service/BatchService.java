package com.habench.shippingadjust.service;

import com.habench.shippingadjust.dao.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class BatchService {
    private String pendingContract;

    public static void register(String value) {
        BatchService self = new BatchService();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        this.pendingContract = ledgerEntry101;
        stage();
    }

    private void stage() {
        String channelTag102 = this.pendingContract;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        ManifestRouter.forward(catalogKey103);
    }
}
