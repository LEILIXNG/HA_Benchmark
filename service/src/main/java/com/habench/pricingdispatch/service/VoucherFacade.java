package com.habench.pricingdispatch.service;

import com.habench.pricingdispatch.dao.ShipmentNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {

    public static void resolve(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        ShipmentNormalizer.expand(paymentTag201);
    }
}
