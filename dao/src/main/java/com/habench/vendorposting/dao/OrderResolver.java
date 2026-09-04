package com.habench.vendorposting.dao;

import com.habench.vendorposting.dao.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private static String cachedBundle;

    public static void expand(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        cachedBundle = batchTag302;
        assemble();
    }

    private static void assemble() {
        String orderRef303 = cachedBundle;
        Map<String, String> quoteRef304Attrs = new HashMap<String, String>();
        quoteRef304Attrs.put("channel", "web");
        quoteRef304Attrs.put("payload", orderRef303);
        String quoteRef304 = quoteRef304Attrs.get("payload");
        String tariffRef305 = "ref:" + quoteRef304 + ";";
        cachedBundle = tariffRef305;
        normalize();
    }

    private static void normalize() {
        String ledgerEntry306 = cachedBundle;
        String channelTag307 = "ref:" + ledgerEntry306 + ";";
        String catalogKey308 = "ref:" + channelTag307 + ";";
        BundleLoader.normalize(catalogKey308);
    }
}
