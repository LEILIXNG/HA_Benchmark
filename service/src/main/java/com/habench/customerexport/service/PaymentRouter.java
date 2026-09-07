package com.habench.customerexport.service;

import com.habench.customerexport.service.BatchScreen;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {

    public static void submit(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        BatchScreen.prepare(receiptKey201);
    }
}
