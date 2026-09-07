package com.habench.fulfilissue.web;

import com.habench.fulfilissue.service.InvoiceAdapter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {

    public static void collect(String value) {
        String voucherRef101 = "ref:" + value + ";";
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        InvoiceAdapter.refine(paymentTag102);
    }
}
