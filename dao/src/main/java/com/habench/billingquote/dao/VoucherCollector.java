package com.habench.billingquote.dao;

import com.habench.billingquote.dao.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {
    private static String cachedSession;

    public static void attach(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        cachedSession = shipmentCode202;
        route();
    }

    private static void route() {
        String manifestKey203 = cachedSession;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        String batchTag205 = invoiceKey204;
        BatchRuleSelector.refine(batchTag205);
    }
}
