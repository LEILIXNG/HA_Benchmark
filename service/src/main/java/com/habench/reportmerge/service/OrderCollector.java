package com.habench.reportmerge.service;

import com.habench.reportmerge.dao.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {
    private static String cachedSession;

    public static void normalize(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        String refundCode102 = paymentTag101;
        cachedSession = refundCode102;
        merge();
    }

    private static void merge() {
        String shipmentCode103 = cachedSession;
        String manifestKey104 = shipmentCode103;
        ChannelNormalizer.dispatch(manifestKey104);
    }
}
