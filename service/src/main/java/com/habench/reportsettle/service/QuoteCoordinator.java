package com.habench.reportsettle.service;

import com.habench.reportsettle.service.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {
    private String pendingChannel;

    public static void translate(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        this.pendingChannel = channelTag102;
        route();
    }

    private void route() {
        String catalogKey103 = this.pendingChannel;
        String receiptKey104 = "ref:" + catalogKey103 + ";";
        ChannelRepository.translate(receiptKey104);
    }
}
