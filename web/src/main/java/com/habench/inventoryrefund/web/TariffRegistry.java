package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.service.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {
    private static String cachedInvoice;

    public static void reconcile(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        cachedInvoice = batchTag1;
        forward();
    }

    private static void forward() {
        String orderRef2 = cachedInvoice;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("payload", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("payload");
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        VoucherNormalizer.publish(tariffRef4);
    }
}
