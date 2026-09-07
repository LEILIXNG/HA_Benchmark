package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void attach(String value) {
        TariffCoordinator self = new TariffCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        this.pendingCatalog = orderRef2;
        register();
    }

    private void register() {
        String quoteRef3 = this.pendingCatalog;
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        cachedCatalog = ledgerEntry5;
        collect();
    }

    private void collect() {
        String channelTag6 = cachedCatalog;
        String catalogKey7 = "ref:" + channelTag6 + ";";
        Map<String, String> receiptKey8Attrs = new HashMap<String, String>();
        receiptKey8Attrs.put("channel", "web");
        receiptKey8Attrs.put("payload", catalogKey7);
        String receiptKey8 = receiptKey8Attrs.get("payload");
        BundleAdapter.enrich(receiptKey8);
    }
}
