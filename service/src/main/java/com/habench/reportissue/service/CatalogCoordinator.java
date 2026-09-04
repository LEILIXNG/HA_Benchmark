package com.habench.reportissue.service;

import com.habench.reportissue.service.CatalogExecutor;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingCatalog;

    public static void merge(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        String orderRef402 = "ref:" + batchTag401 + ";";
        this.pendingCatalog = orderRef402;
        expand();
    }

    private void expand() {
        String quoteRef403 = this.pendingCatalog;
        String tariffRef404 = quoteRef403;
        String ledgerEntry405 = tariffRef404;
        CatalogExecutor.stage(ledgerEntry405);
    }
}
