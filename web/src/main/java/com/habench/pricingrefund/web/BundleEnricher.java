package com.habench.pricingrefund.web;

import com.habench.pricingrefund.service.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleEnricher {
    private static String cachedReceipt;

    public static void forward(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        cachedReceipt = batchTag2;
        translate();
    }

    private static void translate() {
        String orderRef3 = cachedReceipt;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        String tariffRef5 = "ref:" + quoteRef4 + ";";
        cachedReceipt = tariffRef5;
        attach();
    }

    private static void attach() {
        String ledgerEntry6 = cachedReceipt;
        String channelTag7 = ledgerEntry6;
        String catalogKey8 = channelTag7;
        VoucherEnricher.publish(catalogKey8);
    }
}
