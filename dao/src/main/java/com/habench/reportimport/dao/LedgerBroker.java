package com.habench.reportimport.dao;

import com.habench.reportimport.dao.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {

    public static void register(String value) {
        String voucherRef301 = value;
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        BundleEvaluator.normalize(paymentTag302);
    }
}
