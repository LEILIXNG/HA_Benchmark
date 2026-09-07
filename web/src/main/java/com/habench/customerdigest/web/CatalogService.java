package com.habench.customerdigest.web;

import com.habench.customerdigest.web.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        CatalogService self = new CatalogService();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        String orderRef2 = batchTag1;
        cachedBatch = orderRef2;
        assemble();
    }

    private void assemble() {
        String quoteRef3 = cachedBatch;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        this.pendingBatch = tariffRef4;
        merge();
    }

    private void merge() {
        String ledgerEntry5 = this.pendingBatch;
        Map<String, String> channelTag6Attrs = new HashMap<String, String>();
        channelTag6Attrs.put("channel", "web");
        channelTag6Attrs.put("payload", ledgerEntry5);
        String channelTag6 = channelTag6Attrs.get("payload");
        String catalogKey7 = "ref:" + channelTag6 + ";";
        LedgerPlanSelector.prepare(catalogKey7);
    }
}
