package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.ContractNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {
    private String pendingContract;
    private static String cachedContract;

    public static void dispatch(String value) {
        CatalogService self = new CatalogService();
        self.merge(value);
    }

    private void merge(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        this.pendingContract = invoiceKey1;
        enrich();
    }

    private void enrich() {
        String batchTag2 = this.pendingContract;
        String orderRef3 = "ref:" + batchTag2 + ";";
        Map<String, String> quoteRef4Attrs = new HashMap<String, String>();
        quoteRef4Attrs.put("channel", "web");
        quoteRef4Attrs.put("payload", orderRef3);
        String quoteRef4 = quoteRef4Attrs.get("payload");
        cachedContract = quoteRef4;
        translate();
    }

    private void translate() {
        String tariffRef5 = cachedContract;
        String ledgerEntry6 = tariffRef5;
        String channelTag7 = "ref:" + ledgerEntry6 + ";";
        ContractNormalizer.refine(channelTag7);
    }
}
