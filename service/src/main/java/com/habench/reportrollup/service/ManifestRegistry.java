package com.habench.reportrollup.service;

import com.habench.reportrollup.dao.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private static String cachedVoucher;

    public static void dispatch(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = "ref:" + shipmentCode101 + ";";
        cachedVoucher = manifestKey102;
        enrich();
    }

    private static void enrich() {
        String invoiceKey103 = cachedVoucher;
        String batchTag104 = invoiceKey103;
        Map<String, String> orderRef105Attrs = new HashMap<String, String>();
        orderRef105Attrs.put("channel", "web");
        orderRef105Attrs.put("payload", batchTag104);
        String orderRef105 = orderRef105Attrs.get("payload");
        BundleAdapter.forward(orderRef105);
    }
}
