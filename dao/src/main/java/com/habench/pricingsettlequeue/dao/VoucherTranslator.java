package com.habench.pricingsettlequeue.dao;

import com.habench.pricingsettlequeue.dao.CatalogLoader;
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
        String batchTag301 = value;
        String orderRef302 = batchTag301;
        cachedCatalog = orderRef302;
        enrich();
    }

    private void enrich() {
        String quoteRef303 = cachedCatalog;
        Map<String, String> tariffRef304Attrs = new HashMap<String, String>();
        tariffRef304Attrs.put("channel", "web");
        tariffRef304Attrs.put("payload", quoteRef303);
        String tariffRef304 = tariffRef304Attrs.get("payload");
        String ledgerEntry305 = tariffRef304;
        this.pendingCatalog = ledgerEntry305;
        merge();
    }

    private void merge() {
        String channelTag306 = this.pendingCatalog;
        Map<String, String> catalogKey307Attrs = new HashMap<String, String>();
        catalogKey307Attrs.put("channel", "web");
        catalogKey307Attrs.put("payload", channelTag306);
        String catalogKey307 = catalogKey307Attrs.get("payload");
        String receiptKey308 = "ref:" + catalogKey307 + ";";
        CatalogLoader.refine(receiptKey308);
    }
}
