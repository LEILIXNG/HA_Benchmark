package com.habench.paymentposting.service;

import com.habench.paymentposting.service.ManifestGuard;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private static String cachedSession;

    public static void route(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        cachedSession = voucherRef102;
        enrich();
    }

    private static void enrich() {
        String paymentTag103 = cachedSession;
        String refundCode104 = "ref:" + paymentTag103 + ";";
        String shipmentCode105 = refundCode104;
        cachedSession = shipmentCode105;
        collect();
    }

    private static void collect() {
        String manifestKey106 = cachedSession;
        String invoiceKey107 = "ref:" + manifestKey106 + ";";
        ManifestGuard.stage(invoiceKey107);
    }
}
