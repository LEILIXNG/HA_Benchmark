package com.habench.customerrefund.web;

import com.habench.customerrefund.service.InvoiceAdapter;
import java.util.HashMap;
import java.util.Map;

public final class SessionCollector {

    public static void translate(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = voucherRef1;
        InvoiceAdapter.publish(paymentTag2);
    }
}
