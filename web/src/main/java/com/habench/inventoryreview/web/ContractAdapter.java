package com.habench.inventoryreview.web;

import com.habench.inventoryreview.web.RefundEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {

    public static void enrich(String value) {
        String accountRef101 = "ref:" + value + ";";
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        RefundEnricher.dispatch(voucherRef102);
    }
}
