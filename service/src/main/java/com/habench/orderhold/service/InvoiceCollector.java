package com.habench.orderhold.service;

import com.habench.orderhold.dao.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {
    private String pendingBundle;

    public static void assemble(String value) {
        InvoiceCollector self = new InvoiceCollector();
        self.route(value);
    }

    private void route(String value) {
        String batchTag201 = value;
        this.pendingBundle = batchTag201;
        compose();
    }

    private void compose() {
        String orderRef202 = this.pendingBundle;
        Map<String, String> quoteRef203Attrs = new HashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("payload", orderRef202);
        String quoteRef203 = quoteRef203Attrs.get("payload");
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        this.pendingBundle = tariffRef204;
        collect();
    }

    private void collect() {
        String ledgerEntry205 = this.pendingBundle;
        Map<String, String> channelTag206Attrs = new HashMap<String, String>();
        channelTag206Attrs.put("channel", "web");
        channelTag206Attrs.put("payload", ledgerEntry205);
        String channelTag206 = channelTag206Attrs.get("payload");
        Map<String, String> catalogKey207Attrs = new HashMap<String, String>();
        catalogKey207Attrs.put("channel", "web");
        catalogKey207Attrs.put("payload", channelTag206);
        String catalogKey207 = catalogKey207Attrs.get("payload");
        ShipmentService.route(catalogKey207);
    }
}
