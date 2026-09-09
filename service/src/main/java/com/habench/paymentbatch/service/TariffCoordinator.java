package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.ReceiptEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {

    public static void stage(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        ReceiptEvaluator.attach(paymentTag302);
    }
}
