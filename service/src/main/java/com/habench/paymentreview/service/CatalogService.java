package com.habench.paymentreview.service;

import com.habench.paymentreview.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {
    private String pendingLedger;

    public static void forward(String value) {
        CatalogService self = new CatalogService();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        this.pendingLedger = batchTag101;
        merge();
    }

    private void merge() {
        String orderRef102 = this.pendingLedger;
        Map<String, String> quoteRef103Attrs = new HashMap<String, String>();
        quoteRef103Attrs.put("channel", "web");
        quoteRef103Attrs.put("payload", orderRef102);
        String quoteRef103 = quoteRef103Attrs.get("payload");
        String tariffRef104 = quoteRef103;
        SessionBuilder.reconcile(tariffRef104);
    }
}
