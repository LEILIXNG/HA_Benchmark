package com.habench.fulfilbind.service;

import com.habench.fulfilbind.service.BatchFilter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {
    private String pendingCatalog;

    public static void compose(String value) {
        CatalogRegistry self = new CatalogRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String catalogKey201 = "ref:" + value + ";";
        this.pendingCatalog = catalogKey201;
        dispatch();
    }

    private void dispatch() {
        String receiptKey202 = this.pendingCatalog;
        Map<String, String> accountRef203Attrs = new HashMap<String, String>();
        accountRef203Attrs.put("channel", "web");
        accountRef203Attrs.put("payload", receiptKey202);
        String accountRef203 = accountRef203Attrs.get("payload");
        BatchFilter.assemble(accountRef203);
    }
}
