package com.habench.paymenthold.dao;

import com.habench.paymenthold.dao.ShipmentPolicy;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {

    public static void attach(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        String refundCode502 = paymentTag501;
        ShipmentPolicy.translate(refundCode502);
    }
}
