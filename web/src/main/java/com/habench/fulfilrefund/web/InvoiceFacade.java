package com.habench.fulfilrefund.web;

import com.habench.fulfilrefund.service.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceFacade {

    public static void enrich(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        CatalogBuilder.submit(paymentTag2);
    }
}
