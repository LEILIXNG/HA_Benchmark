package com.habench.reportsplit.service;

import com.habench.reportsplit.dao.SessionEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private static String cachedReceipt;

    public static void stage(String value) {
        String paymentTag101 = "ref:" + value + ";";
        cachedReceipt = paymentTag101;
        normalize();
    }

    private static void normalize() {
        String refundCode102 = cachedReceipt;
        String shipmentCode103 = refundCode102;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        cachedReceipt = manifestKey104;
        expand();
    }

    private static void expand() {
        String invoiceKey105 = cachedReceipt;
        String batchTag106 = "ref:" + invoiceKey105 + ";";
        SessionEnricher.register(batchTag106);
    }
}
