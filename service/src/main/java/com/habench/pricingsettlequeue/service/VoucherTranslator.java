package com.habench.pricingsettlequeue.service;

import com.habench.pricingsettlequeue.service.CatalogLoader;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void assemble(String value) {
        VoucherTranslator self = new VoucherTranslator();
        self.submit(value);
    }

    private void submit(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        cachedCatalog = batchTag102;
        enrich();
    }

    private void enrich() {
        String orderRef103 = cachedCatalog;
        String quoteRef104 = orderRef103;
        String tariffRef105 = "ref:" + quoteRef104 + ";";
        this.pendingCatalog = tariffRef105;
        merge();
    }

    private void merge() {
        String ledgerEntry106 = this.pendingCatalog;
        String channelTag107 = ledgerEntry106;
        Map<String, String> catalogKey108Attrs = new HashMap<String, String>();
        catalogKey108Attrs.put("channel", "web");
        catalogKey108Attrs.put("payload", channelTag107);
        String catalogKey108 = catalogKey108Attrs.get("payload");
        CatalogLoader.refine(catalogKey108);
    }
}
