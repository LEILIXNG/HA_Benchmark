package com.habench.accountassign.service;

import com.habench.accountassign.dao.ManifestBroker;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {
    private String pendingManifest;
    private static String cachedManifest;

    public static void collect(String value) {
        ChannelService self = new ChannelService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = "ref:" + orderRef101 + ";";
        cachedManifest = quoteRef102;
        submit();
    }

    private void submit() {
        String tariffRef103 = cachedManifest;
        String ledgerEntry104 = tariffRef103;
        this.pendingManifest = ledgerEntry104;
        publish();
    }

    private void publish() {
        String channelTag105 = this.pendingManifest;
        Map<String, String> catalogKey106Attrs = new HashMap<String, String>();
        catalogKey106Attrs.put("channel", "web");
        catalogKey106Attrs.put("payload", channelTag105);
        String catalogKey106 = catalogKey106Attrs.get("payload");
        this.pendingManifest = catalogKey106;
        dispatch();
    }

    private void dispatch() {
        String receiptKey107 = this.pendingManifest;
        String accountRef108 = receiptKey107;
        ManifestBroker.refine(accountRef108);
    }
}
