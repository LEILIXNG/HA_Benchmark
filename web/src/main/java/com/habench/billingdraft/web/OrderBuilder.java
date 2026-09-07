package com.habench.billingdraft.web;

import com.habench.billingdraft.web.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {
    private String pendingChannel;

    public static void attach(String value) {
        OrderBuilder self = new OrderBuilder();
        self.submit(value);
    }

    private void submit(String value) {
        String ledgerEntry1 = value;
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        this.pendingChannel = channelTag2;
        dispatch();
    }

    private void dispatch() {
        String catalogKey3 = this.pendingChannel;
        String receiptKey4 = catalogKey3;
        String accountRef5 = receiptKey4;
        BundlePolicySelector.prepare(accountRef5);
    }
}
