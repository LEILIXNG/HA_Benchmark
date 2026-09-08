package com.habench.inventoryledger.service;

import com.habench.inventoryledger.dao.ChannelBroker;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {
    private String pendingOrder;

    public static void dispatch(String value) {
        TariffAdapter self = new TariffAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        this.pendingOrder = batchTag201;
        route();
    }

    private void route() {
        String orderRef202 = this.pendingOrder;
        Map<String, String> quoteRef203Attrs = new HashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("payload", orderRef202);
        String quoteRef203 = quoteRef203Attrs.get("payload");
        String tariffRef204 = quoteRef203;
        ChannelBroker.enrich(tariffRef204);
    }
}
