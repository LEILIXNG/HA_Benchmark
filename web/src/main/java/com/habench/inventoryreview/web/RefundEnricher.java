package com.habench.inventoryreview.web;

import com.habench.inventoryreview.service.VoucherCollector;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void dispatch(String value) {
        String tariffRef201 = "ref:" + value + ";";
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        VoucherCollector.route(ledgerEntry202);
    }
}
