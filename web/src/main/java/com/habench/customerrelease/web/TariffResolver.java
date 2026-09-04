package com.habench.customerrelease.web;

import com.habench.customerrelease.web.ReceiptTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffResolver {

    public static void route(String value) {
        String accountRef201 = "ref:" + value + ";";
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        ReceiptTranslator.stage(voucherRef202);
    }
}
