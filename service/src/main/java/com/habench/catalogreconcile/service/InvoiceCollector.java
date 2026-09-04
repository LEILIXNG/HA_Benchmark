package com.habench.catalogreconcile.service;

import com.habench.catalogreconcile.dao.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {

    public static void compose(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        PaymentResolver.submit(voucherRef201);
    }
}
