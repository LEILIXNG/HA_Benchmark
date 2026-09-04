package com.habench.vendorreconcile.service;

import com.habench.vendorreconcile.dao.ReceiptRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedBundle;

    public static void stage(String value) {
        String manifestKey201 = value;
        cachedBundle = manifestKey201;
        normalize();
    }

    private static void normalize() {
        String invoiceKey202 = cachedBundle;
        Map<String, String> batchTag203Attrs = new HashMap<String, String>();
        batchTag203Attrs.put("channel", "web");
        batchTag203Attrs.put("payload", invoiceKey202);
        String batchTag203 = batchTag203Attrs.get("payload");
        ReceiptRouter.assemble(batchTag203);
    }
}
