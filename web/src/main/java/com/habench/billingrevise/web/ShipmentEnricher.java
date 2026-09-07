package com.habench.billingrevise.web;

import com.habench.billingrevise.service.PaymentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void forward(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        PaymentAdapter.dispatch(refundCode102);
    }
}
