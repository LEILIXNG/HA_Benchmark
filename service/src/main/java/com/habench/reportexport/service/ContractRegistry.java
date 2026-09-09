package com.habench.reportexport.service;

import com.habench.reportexport.dao.RefundAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ContractRegistry {
    private static String cachedPayment;

    public static void register(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        cachedPayment = invoiceKey202;
        translate();
    }

    private static void translate() {
        String batchTag203 = cachedPayment;
        String orderRef204 = "ref:" + batchTag203 + ";";
        RefundAdapter.refine(orderRef204);
    }
}
