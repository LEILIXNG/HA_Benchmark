package com.habench.vendorreview.web;

import com.habench.vendorreview.service.OrderFacade;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void compose(String value) {
        BatchFacade self = new BatchFacade();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        this.pendingCatalog = batchTag102;
        refine();
    }

    private void refine() {
        String orderRef103 = this.pendingCatalog;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        String tariffRef105 = quoteRef104;
        this.pendingCatalog = tariffRef105;
        assemble();
    }

    private void assemble() {
        String ledgerEntry106 = this.pendingCatalog;
        String channelTag107 = "ref:" + ledgerEntry106 + ";";
        cachedCatalog = channelTag107;
        enrich();
    }

    private void enrich() {
        String catalogKey108 = cachedCatalog;
        String receiptKey109 = "ref:" + catalogKey108 + ";";
        OrderFacade.route(receiptKey109);
    }
}
