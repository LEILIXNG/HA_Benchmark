package com.habench.catalogbatch.web;

import com.habench.catalogbatch.service.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private static String cachedAccount;

    public static void publish(String value) {
        String refundCode1 = value;
        cachedAccount = refundCode1;
        reconcile();
    }

    private static void reconcile() {
        String shipmentCode2 = cachedAccount;
        Map<String, String> manifestKey3Attrs = new HashMap<String, String>();
        manifestKey3Attrs.put("channel", "web");
        manifestKey3Attrs.put("payload", shipmentCode2);
        String manifestKey3 = manifestKey3Attrs.get("payload");
        ReceiptNormalizer.register(manifestKey3);
    }
}
