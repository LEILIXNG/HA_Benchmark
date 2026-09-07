package com.habench.billingcapture.service;

import com.habench.billingcapture.service.VoucherPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void submit(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        String refundCode102 = paymentTag101;
        VoucherPlanSelector.forward(refundCode102);
    }
}
