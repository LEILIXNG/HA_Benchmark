package com.habench.fulfilbind.dao;

import com.habench.fulfilbind.dao.CatalogEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void refine(String value) {
        BatchRegistry self = new BatchRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        String quoteRef302 = orderRef301;
        cachedCatalog = quoteRef302;
        publish();
    }

    private void publish() {
        String tariffRef303 = cachedCatalog;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        this.pendingCatalog = ledgerEntry304;
        merge();
    }

    private void merge() {
        String channelTag305 = this.pendingCatalog;
        Map<String, String> catalogKey306Attrs = new HashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("payload", channelTag305);
        String catalogKey306 = catalogKey306Attrs.get("payload");
        String receiptKey307 = catalogKey306;
        this.pendingCatalog = receiptKey307;
        stage();
    }

    private void stage() {
        String accountRef308 = this.pendingCatalog;
        String voucherRef309 = "ref:" + accountRef308 + ";";
        String paymentTag310 = "ref:" + voucherRef309 + ";";
        CatalogEvaluator.register(paymentTag310);
    }
}
