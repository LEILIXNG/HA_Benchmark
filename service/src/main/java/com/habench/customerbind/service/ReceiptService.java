package com.habench.customerbind.service;

import com.habench.customerbind.dao.InvoiceBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private static String cachedVoucher;

    public static void expand(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        cachedVoucher = manifestKey102;
        route();
    }

    private static void route() {
        String invoiceKey103 = cachedVoucher;
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        InvoiceBroker.publish(batchTag104);
    }
}
