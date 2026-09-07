package com.habench.reportimport.web;

import com.habench.reportimport.web.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {

    public static void expand(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        ManifestStrategySelector.stage(paymentTag2);
    }
}
