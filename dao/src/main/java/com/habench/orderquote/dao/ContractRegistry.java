package com.habench.orderquote.dao;

import com.habench.orderquote.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void refine(String value) {
        ContractRegistry self = new ContractRegistry();
        self.register(value);
    }

    private void register(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        this.pendingBundle = quoteRef302;
        merge();
    }

    private void merge() {
        String tariffRef303 = this.pendingBundle;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        cachedBundle = ledgerEntry304;
        stage();
    }

    private void stage() {
        String channelTag305 = cachedBundle;
        Map<String, String> catalogKey306Attrs = new HashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("payload", channelTag305);
        String catalogKey306 = catalogKey306Attrs.get("payload");
        BundleExecutor.reconcile(catalogKey306);
    }
}
