package com.habench.customersubmit.service;

import com.habench.customersubmit.service.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void prepare(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = receiptKey101;
        ReceiptEnricher.compose(accountRef102);
    }
}
