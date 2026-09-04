package com.habench.billingcapture.web;

import com.habench.billingcapture.service.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void submit(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        VoucherTranslator.forward(paymentTag2);
    }
}
