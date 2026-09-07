package com.habench.accountsettle.service;

import com.habench.accountsettle.dao.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {
    private String pendingSession;

    public static void prepare(String value) {
        VoucherResolver self = new VoucherResolver();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        this.pendingSession = refundCode401;
        translate();
    }

    private void translate() {
        String shipmentCode402 = this.pendingSession;
        String manifestKey403 = "ref:" + shipmentCode402 + ";";
        CatalogRegistry.reconcile(manifestKey403);
    }
}
