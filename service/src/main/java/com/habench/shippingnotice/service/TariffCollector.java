package com.habench.shippingnotice.service;

import com.habench.shippingnotice.dao.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {

    public static void forward(String value) {
        String voucherRef101 = "ref:" + value + ";";
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        AccountAdapter.reconcile(paymentTag102);
    }
}
