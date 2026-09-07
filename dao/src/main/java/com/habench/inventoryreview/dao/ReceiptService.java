package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.PaymentCollector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private static String cachedContract;

    public static void dispatch(String value) {
        String manifestKey601 = "ref:" + value + ";";
        Map<String, String> invoiceKey602Attrs = new HashMap<String, String>();
        invoiceKey602Attrs.put("channel", "web");
        invoiceKey602Attrs.put("payload", manifestKey601);
        String invoiceKey602 = invoiceKey602Attrs.get("payload");
        cachedContract = invoiceKey602;
        refine();
    }

    private static void refine() {
        String batchTag603 = cachedContract;
        String orderRef604 = batchTag603;
        PaymentCollector.enrich(orderRef604);
    }
}
