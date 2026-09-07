package com.habench.vendorsync.service;

import com.habench.vendorsync.service.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {
    private String pendingBatch;

    public static void stage(String value) {
        BatchNormalizer self = new BatchNormalizer();
        self.normalize(value);
    }

    private void normalize(String value) {
        String manifestKey101 = value;
        this.pendingBatch = manifestKey101;
        assemble();
    }

    private void assemble() {
        String invoiceKey102 = this.pendingBatch;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        TariffPolicySelector.register(orderRef104);
    }
}
