package com.habench.customerintake.web;

import com.habench.customerintake.service.ShipmentAssembler;
import java.util.HashMap;
import java.util.Map;

public final class VoucherNormalizer {

    public static void enrich(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = "ref:" + receiptKey1 + ";";
        ShipmentAssembler.publish(accountRef2);
    }
}
