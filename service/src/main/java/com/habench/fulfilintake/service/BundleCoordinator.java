package com.habench.fulfilintake.service;

import com.habench.fulfilintake.service.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private static String cachedSession;

    public static void collect(String value) {
        String receiptKey301 = value;
        String accountRef302 = "ref:" + receiptKey301 + ";";
        cachedSession = accountRef302;
        expand();
    }

    private static void expand() {
        String voucherRef303 = cachedSession;
        String paymentTag304 = voucherRef303;
        Map<String, String> refundCode305Attrs = new HashMap<String, String>();
        refundCode305Attrs.put("channel", "web");
        refundCode305Attrs.put("payload", paymentTag304);
        String refundCode305 = refundCode305Attrs.get("payload");
        SessionEvaluator.normalize(refundCode305);
    }
}
