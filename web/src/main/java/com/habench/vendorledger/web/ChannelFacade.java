package com.habench.vendorledger.web;

import com.habench.vendorledger.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelFacade {
    private String pendingChannel;

    public static void refine(String value) {
        ChannelFacade self = new ChannelFacade();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        this.pendingChannel = tariffRef102;
        enrich();
    }

    private void enrich() {
        String ledgerEntry103 = this.pendingChannel;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        this.pendingChannel = channelTag104;
        register();
    }

    private void register() {
        String catalogKey105 = this.pendingChannel;
        String receiptKey106 = catalogKey105;
        CatalogRegistry.submit(receiptKey106);
    }
}
