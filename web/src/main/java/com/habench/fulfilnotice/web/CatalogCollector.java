package com.habench.fulfilnotice.web;

import com.habench.fulfilnotice.web.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private static String cachedRefund;

    public static void route(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        cachedRefund = voucherRef1;
        refine();
    }

    private static void refine() {
        String paymentTag2 = cachedRefund;
        String refundCode3 = paymentTag2;
        RefundPolicySelector.stage(refundCode3);
    }
}
