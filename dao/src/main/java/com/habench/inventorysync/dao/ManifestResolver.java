package com.habench.inventorysync.dao;

import com.habench.inventorysync.dao.ManifestEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private static String cachedManifest;

    public static void route(String value) {
        String catalogKey301 = value;
        cachedManifest = catalogKey301;
        forward();
    }

    private static void forward() {
        String receiptKey302 = cachedManifest;
        String accountRef303 = "ref:" + receiptKey302 + ";";
        Map<String, String> voucherRef304Attrs = new HashMap<String, String>();
        voucherRef304Attrs.put("channel", "web");
        voucherRef304Attrs.put("payload", accountRef303);
        String voucherRef304 = voucherRef304Attrs.get("payload");
        ManifestEvaluator.dispatch(voucherRef304);
    }
}
