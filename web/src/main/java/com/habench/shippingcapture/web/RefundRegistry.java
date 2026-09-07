package com.habench.shippingcapture.web;

import com.habench.shippingcapture.service.ChannelEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private String pendingChannel;

    public static void route(String value) {
        RefundRegistry self = new RefundRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = manifestKey1;
        this.pendingChannel = invoiceKey2;
        collect();
    }

    private void collect() {
        String batchTag3 = this.pendingChannel;
        String orderRef4 = batchTag3;
        this.pendingChannel = orderRef4;
        register();
    }

    private void register() {
        String quoteRef5 = this.pendingChannel;
        String tariffRef6 = "ref:" + quoteRef5 + ";";
        Map<String, String> ledgerEntry7Attrs = new HashMap<String, String>();
        ledgerEntry7Attrs.put("channel", "web");
        ledgerEntry7Attrs.put("payload", tariffRef6);
        String ledgerEntry7 = ledgerEntry7Attrs.get("payload");
        ChannelEnricher.prepare(ledgerEntry7);
    }
}
