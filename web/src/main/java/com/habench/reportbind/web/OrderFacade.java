package com.habench.reportbind.web;

import com.habench.reportbind.web.RefundRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {
    private static String cachedContract;

    public static void enrich(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = voucherRef1;
        cachedContract = paymentTag2;
        assemble();
    }

    private static void assemble() {
        String refundCode3 = cachedContract;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        String manifestKey5 = "ref:" + shipmentCode4 + ";";
        RefundRuleSelector.merge(manifestKey5);
    }
}
