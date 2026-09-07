package com.habench.billingadjust.web;

import com.habench.billingadjust.service.ContractAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {

    public static void prepare(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        ContractAdapter.dispatch(paymentTag102);
    }
}
