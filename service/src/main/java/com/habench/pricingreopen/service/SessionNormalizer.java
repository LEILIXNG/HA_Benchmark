package com.habench.pricingreopen.service;

import com.habench.pricingreopen.service.ReceiptStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {
    private String pendingAccount;

    public static void resolve(String value) {
        SessionNormalizer self = new SessionNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingAccount = tariffRef201;
        merge();
    }

    private void merge() {
        String ledgerEntry202 = this.pendingAccount;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        this.pendingAccount = channelTag203;
        route();
    }

    private void route() {
        String catalogKey204 = this.pendingAccount;
        Map<String, String> receiptKey205Attrs = new HashMap<String, String>();
        receiptKey205Attrs.put("channel", "web");
        receiptKey205Attrs.put("payload", catalogKey204);
        String receiptKey205 = receiptKey205Attrs.get("payload");
        ReceiptStrategySelector.translate(receiptKey205);
    }
}
