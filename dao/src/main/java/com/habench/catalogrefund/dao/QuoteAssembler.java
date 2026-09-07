package com.habench.catalogrefund.dao;

import com.habench.catalogrefund.dao.CatalogScreen;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingBatch;

    public static void attach(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.collect(value);
    }

    private void collect(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        this.pendingBatch = invoiceKey202;
        enrich();
    }

    private void enrich() {
        String batchTag203 = this.pendingBatch;
        String orderRef204 = "ref:" + batchTag203 + ";";
        String quoteRef205 = "ref:" + orderRef204 + ";";
        CatalogScreen.route(quoteRef205);
    }
}
