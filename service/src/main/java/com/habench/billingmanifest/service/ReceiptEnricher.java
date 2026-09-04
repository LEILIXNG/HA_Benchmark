package com.habench.billingmanifest.service;

import com.habench.billingmanifest.dao.ReceiptAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {
    private static String cachedChannel;

    public static void resolve(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        cachedChannel = shipmentCode102;
        prepare();
    }

    private static void prepare() {
        String manifestKey103 = cachedChannel;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        String batchTag105 = "ref:" + invoiceKey104 + ";";
        ReceiptAdapter.dispatch(batchTag105);
    }
}
