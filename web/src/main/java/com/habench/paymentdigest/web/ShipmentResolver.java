package com.habench.paymentdigest.web;

import com.habench.paymentdigest.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentResolver {

    public static void prepare(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = receiptKey1;
        VoucherBroker.register(accountRef2);
    }
}
