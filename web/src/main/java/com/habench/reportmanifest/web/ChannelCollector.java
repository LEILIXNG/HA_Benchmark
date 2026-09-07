package com.habench.reportmanifest.web;

import com.habench.reportmanifest.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {
    private String pendingRefund;

    public static void forward(String value) {
        ChannelCollector self = new ChannelCollector();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        this.pendingRefund = tariffRef2;
        enrich();
    }

    private void enrich() {
        String ledgerEntry3 = this.pendingRefund;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        this.pendingRefund = channelTag4;
        collect();
    }

    private void collect() {
        String catalogKey5 = this.pendingRefund;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("payload", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("payload");
        Map<String, String> accountRef7Attrs = new HashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("payload", receiptKey6);
        String accountRef7 = accountRef7Attrs.get("payload");
        OrderComposer.collect(accountRef7);
    }
}
