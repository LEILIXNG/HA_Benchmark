package com.habench.billingnotice.service;

import com.habench.billingnotice.dao.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {

    public static void register(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        TariffEnricher.publish(refundCode102);
    }
}
