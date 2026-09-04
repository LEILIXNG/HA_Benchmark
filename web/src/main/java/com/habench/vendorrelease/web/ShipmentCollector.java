package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private static String cachedRefund;

    public static void publish(String value) {
        String catalogKey1 = value;
        cachedRefund = catalogKey1;
        resolve();
    }

    private static void resolve() {
        String receiptKey2 = cachedRefund;
        Map<String, String> accountRef3Attrs = new HashMap<String, String>();
        accountRef3Attrs.put("channel", "web");
        accountRef3Attrs.put("payload", receiptKey2);
        String accountRef3 = accountRef3Attrs.get("payload");
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        ShipmentPlanSelector.translate(voucherRef4);
    }
}
