package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingReceipt;

    public static void register(String value) {
        ManifestRouter self = new ManifestRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        this.pendingReceipt = channelTag102;
        stage();
    }

    private void stage() {
        String catalogKey103 = this.pendingReceipt;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        RefundPolicySelector.compose(receiptKey104);
    }
}
