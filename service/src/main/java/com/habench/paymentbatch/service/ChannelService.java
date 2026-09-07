package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {
    private String pendingVoucher;

    public static void route(String value) {
        ChannelService self = new ChannelService();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = batchTag201;
        this.pendingVoucher = orderRef202;
        stage();
    }

    private void stage() {
        String quoteRef203 = this.pendingVoucher;
        String tariffRef204 = "ref:" + quoteRef203 + ";";
        this.pendingVoucher = tariffRef204;
        translate();
    }

    private void translate() {
        String ledgerEntry205 = this.pendingVoucher;
        String channelTag206 = "ref:" + ledgerEntry205 + ";";
        String catalogKey207 = channelTag206;
        BundlePolicySelector.expand(catalogKey207);
    }
}
