package com.habench.ordertrace.web;

import com.habench.ordertrace.service.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {

    public static void submit(String value) {
        String voucherRef301 = value;
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        ManifestFacade.expand(paymentTag302);
    }
}
