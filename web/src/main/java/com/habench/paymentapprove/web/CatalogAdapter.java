package com.habench.paymentapprove.web;

import com.habench.paymentapprove.web.CatalogNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {
    private String pendingAccount;

    public static void normalize(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag1 = "ref:" + value + ";";
        this.pendingAccount = batchTag1;
        attach();
    }

    private void attach() {
        String orderRef2 = this.pendingAccount;
        String quoteRef3 = orderRef2;
        this.pendingAccount = quoteRef3;
        resolve();
    }

    private void resolve() {
        String tariffRef4 = this.pendingAccount;
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        CatalogNormalizer.stage(ledgerEntry5);
    }
}
