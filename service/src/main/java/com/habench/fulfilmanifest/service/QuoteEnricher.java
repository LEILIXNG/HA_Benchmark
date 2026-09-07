package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.service.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {
    private String pendingChannel;
    private static String cachedChannel;

    public static void resolve(String value) {
        QuoteEnricher self = new QuoteEnricher();
        self.refine(value);
    }

    private void refine(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        this.pendingChannel = shipmentCode201;
        translate();
    }

    private void translate() {
        String manifestKey202 = this.pendingChannel;
        String invoiceKey203 = "ref:" + manifestKey202 + ";";
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        this.pendingChannel = batchTag204;
        compose();
    }

    private void compose() {
        String orderRef205 = this.pendingChannel;
        Map<String, String> quoteRef206Attrs = new HashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("payload", orderRef205);
        String quoteRef206 = quoteRef206Attrs.get("payload");
        Map<String, String> tariffRef207Attrs = new HashMap<String, String>();
        tariffRef207Attrs.put("channel", "web");
        tariffRef207Attrs.put("payload", quoteRef206);
        String tariffRef207 = tariffRef207Attrs.get("payload");
        cachedChannel = tariffRef207;
        attach();
    }

    private void attach() {
        String ledgerEntry208 = cachedChannel;
        Map<String, String> channelTag209Attrs = new HashMap<String, String>();
        channelTag209Attrs.put("channel", "web");
        channelTag209Attrs.put("payload", ledgerEntry208);
        String channelTag209 = channelTag209Attrs.get("payload");
        String catalogKey210 = "ref:" + channelTag209 + ";";
        ChannelRepository.stage(catalogKey210);
    }
}
