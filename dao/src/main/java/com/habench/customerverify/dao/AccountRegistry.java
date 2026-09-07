package com.habench.customerverify.dao;

import com.habench.customerverify.dao.TariffEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class AccountRegistry {

    public static void compose(String value) {
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("payload", value);
        String voucherRef501 = voucherRef501Attrs.get("payload");
        Map<String, String> paymentTag502Attrs = new HashMap<String, String>();
        paymentTag502Attrs.put("channel", "web");
        paymentTag502Attrs.put("payload", voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get("payload");
        TariffEvaluator.forward(paymentTag502);
    }
}
