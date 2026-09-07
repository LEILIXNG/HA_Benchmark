package com.habench.fulfilsettle.web;

import com.habench.fulfilsettle.service.VoucherCollector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {

    public static void forward(String value) {
        String voucherRef101 = "ref:" + value + ";";
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        VoucherCollector.enrich(paymentTag102);
    }
}
