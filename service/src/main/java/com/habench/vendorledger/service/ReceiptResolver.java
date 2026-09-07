package com.habench.vendorledger.service;

import com.habench.vendorledger.service.BatchRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {
    private String pendingBatch;

    public static void dispatch(String value) {
        ReceiptResolver self = new ReceiptResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef201 = value;
        this.pendingBatch = tariffRef201;
        register();
    }

    private void register() {
        String ledgerEntry202 = this.pendingBatch;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        String catalogKey204 = channelTag203;
        BatchRepository.prepare(catalogKey204);
    }
}
