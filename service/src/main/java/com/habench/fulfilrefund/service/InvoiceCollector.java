package com.habench.fulfilrefund.service;

import com.habench.fulfilrefund.service.BatchService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {

    public static void assemble(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        BatchService.collect(voucherRef301);
    }
}
