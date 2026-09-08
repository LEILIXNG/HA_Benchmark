package com.habench.catalogassign.web;

import com.habench.catalogassign.web.CatalogGateway;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void normalize(String value) {
        QuoteRouter self = new QuoteRouter();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey101 = "ref:" + value + ";";
        cachedCatalog = manifestKey101;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey102 = cachedCatalog;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        this.pendingCatalog = orderRef104;
        stage();
    }

    private void stage() {
        String quoteRef105 = this.pendingCatalog;
        String tariffRef106 = quoteRef105;
        cachedCatalog = tariffRef106;
        expand();
    }

    private void expand() {
        String ledgerEntry107 = cachedCatalog;
        String channelTag108 = "ref:" + ledgerEntry107 + ";";
        String catalogKey109 = channelTag108;
        CatalogGateway.submit(catalogKey109);
    }
}
