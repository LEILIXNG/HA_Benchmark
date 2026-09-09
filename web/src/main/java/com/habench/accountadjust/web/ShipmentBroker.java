package com.habench.accountadjust.web;

import com.habench.accountadjust.service.PaymentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void submit(String value) {
        String accountRef101 = "ref:" + value + ";";
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        PaymentRegistry.enrich(voucherRef102);
    }
}
