package com.habench.shippingdispatch.dao;

import com.habench.shippingdispatch.dao.AccountBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogComposer {
    private String pendingBundle;

    public static void assemble(String value) {
        CatalogComposer self = new CatalogComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String tariffRef201 = "ref:" + value + ";";
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        this.pendingBundle = ledgerEntry202;
        merge();
    }

    private void merge() {
        String channelTag203 = this.pendingBundle;
        Map<String, String> catalogKey204Attrs = new HashMap<String, String>();
        catalogKey204Attrs.put("channel", "web");
        catalogKey204Attrs.put("payload", channelTag203);
        String catalogKey204 = catalogKey204Attrs.get("payload");
        AccountBroker.translate(catalogKey204);
    }
}
