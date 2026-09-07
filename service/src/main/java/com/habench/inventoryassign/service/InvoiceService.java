package com.habench.inventoryassign.service;

import com.habench.inventoryassign.dao.ManifestTranslator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {

    public static void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        ManifestTranslator.compose(orderRef101);
    }
}
