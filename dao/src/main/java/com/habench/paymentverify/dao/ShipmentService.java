package com.habench.paymentverify.dao;

import com.habench.paymentverify.dao.InvoiceGateway;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {

    public static void reconcile(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("payload", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("payload");
        InvoiceGateway.forward(receiptKey302);
    }
}
