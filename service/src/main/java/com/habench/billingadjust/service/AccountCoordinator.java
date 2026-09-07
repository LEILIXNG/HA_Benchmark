package com.habench.billingadjust.service;

import com.habench.billingadjust.service.LedgerFetcher;
import java.util.HashMap;
import java.util.Map;

public final class AccountCoordinator {
    private static String cachedLedger;

    public static void collect(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        cachedLedger = invoiceKey301;
        enrich();
    }

    private static void enrich() {
        String batchTag302 = cachedLedger;
        Map<String, String> orderRef303Attrs = new HashMap<String, String>();
        orderRef303Attrs.put("channel", "web");
        orderRef303Attrs.put("payload", batchTag302);
        String orderRef303 = orderRef303Attrs.get("payload");
        LedgerFetcher.enrich(orderRef303);
    }
}
