package com.habench.fulfilissue.web;

import com.habench.fulfilissue.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BatchAdapter {
    private static String cachedPayment;

    public static void compose(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = "ref:" + paymentTag1 + ";";
        cachedPayment = refundCode2;
        resolve();
    }

    private static void resolve() {
        String shipmentCode3 = cachedPayment;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        LedgerCoordinator.stage(manifestKey4);
    }
}
