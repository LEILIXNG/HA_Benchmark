package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.service.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private String pendingChannel;

    public static void register(String value) {
        ChannelRouter self = new ChannelRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        this.pendingChannel = ledgerEntry101;
        route();
    }

    private void route() {
        String channelTag102 = this.pendingChannel;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        this.pendingChannel = receiptKey104;
        compose();
    }

    private void compose() {
        String accountRef105 = this.pendingChannel;
        String voucherRef106 = "ref:" + accountRef105 + ";";
        ManifestFacade.submit(voucherRef106);
    }
}
