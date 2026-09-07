package com.habench.pricingdraft.dao;

import com.habench.pricingdraft.dao.ChannelEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {
    private String pendingChannel;

    public static void compose(String value) {
        BundleAdapter self = new BundleAdapter();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        this.pendingChannel = ledgerEntry301;
        prepare();
    }

    private void prepare() {
        String channelTag302 = this.pendingChannel;
        String catalogKey303 = "ref:" + channelTag302 + ";";
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        ChannelEvaluator.compose(receiptKey304);
    }
}
