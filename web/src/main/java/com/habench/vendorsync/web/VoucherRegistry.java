package com.habench.vendorsync.web;

import com.habench.vendorsync.service.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {
    private static String cachedBatch;

    public static void collect(String value) {
        String paymentTag101 = "ref:" + value + ";";
        cachedBatch = paymentTag101;
        translate();
    }

    private static void translate() {
        String refundCode102 = cachedBatch;
        Map<String, String> shipmentCode103Attrs = new HashMap<String, String>();
        shipmentCode103Attrs.put("channel", "web");
        shipmentCode103Attrs.put("payload", refundCode102);
        String shipmentCode103 = shipmentCode103Attrs.get("payload");
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        AccountAdapter.normalize(manifestKey104);
    }
}
