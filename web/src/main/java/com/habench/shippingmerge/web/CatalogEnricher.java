package com.habench.shippingmerge.web;

import com.habench.shippingmerge.service.BundleComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {
    private String pendingAccount;

    public static void merge(String value) {
        CatalogEnricher self = new CatalogEnricher();
        self.attach(value);
    }

    private void attach(String value) {
        String batchTag101 = value;
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        this.pendingAccount = orderRef102;
        forward();
    }

    private void forward() {
        String quoteRef103 = this.pendingAccount;
        String tariffRef104 = "ref:" + quoteRef103 + ";";
        BundleComposer.assemble(tariffRef104);
    }
}
