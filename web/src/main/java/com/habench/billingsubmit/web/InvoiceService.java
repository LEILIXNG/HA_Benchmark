package com.habench.billingsubmit.web;

import com.habench.billingsubmit.service.ShipmentCollector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {

    public static void normalize(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        ShipmentCollector.resolve(paymentTag2);
    }
}
