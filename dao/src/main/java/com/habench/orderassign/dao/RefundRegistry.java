package com.habench.orderassign.dao;

import com.habench.orderassign.dao.ContractTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedReceipt;

    public static void normalize(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        String refundCode402 = "ref:" + paymentTag401 + ";";
        cachedReceipt = refundCode402;
        submit();
    }

    private static void submit() {
        String shipmentCode403 = cachedReceipt;
        String manifestKey404 = shipmentCode403;
        String invoiceKey405 = manifestKey404;
        ContractTranslator.dispatch(invoiceKey405);
    }
}
