package com.habench.customerdigest.web;

import com.habench.customerdigest.web.CatalogStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {
    private String pendingBatch;

    public static void normalize(String value) {
        ChannelAssembler self = new ChannelAssembler();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        this.pendingBatch = batchTag1;
        merge();
    }

    private void merge() {
        String orderRef2 = this.pendingBatch;
        String quoteRef3 = orderRef2;
        String tariffRef4 = quoteRef3;
        CatalogStrategySelector.prepare(tariffRef4);
    }
}
