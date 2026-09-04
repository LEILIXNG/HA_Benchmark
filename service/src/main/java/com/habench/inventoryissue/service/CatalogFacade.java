package com.habench.inventoryissue.service;

import com.habench.inventoryissue.service.QuoteStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private String pendingLedger;
    private static String cachedLedger;

    public static void resolve(String value) {
        CatalogFacade self = new CatalogFacade();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey101 = "ref:" + value + ";";
        cachedLedger = manifestKey101;
        normalize();
    }

    private void normalize() {
        String invoiceKey102 = cachedLedger;
        String batchTag103 = invoiceKey102;
        this.pendingLedger = batchTag103;
        enrich();
    }

    private void enrich() {
        String orderRef104 = this.pendingLedger;
        Map<String, String> quoteRef105Attrs = new HashMap<String, String>();
        quoteRef105Attrs.put("channel", "web");
        quoteRef105Attrs.put("payload", orderRef104);
        String quoteRef105 = quoteRef105Attrs.get("payload");
        cachedLedger = quoteRef105;
        publish();
    }

    private void publish() {
        String tariffRef106 = cachedLedger;
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        String channelTag108 = ledgerEntry107;
        QuoteStrategySelector.reconcile(channelTag108);
    }
}
