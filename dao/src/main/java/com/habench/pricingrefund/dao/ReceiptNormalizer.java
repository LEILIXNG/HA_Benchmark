package com.habench.pricingrefund.dao;

import com.habench.pricingrefund.dao.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptNormalizer {
    private String pendingReceipt;

    public static void dispatch(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.expand(value);
    }

    private void expand(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        this.pendingReceipt = channelTag202;
        stage();
    }

    private void stage() {
        String catalogKey203 = this.pendingReceipt;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        BatchBroker.enrich(receiptKey204);
    }
}
