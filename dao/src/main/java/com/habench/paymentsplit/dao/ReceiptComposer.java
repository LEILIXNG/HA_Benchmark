package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.ReceiptPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {

    public static void compose(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        ReceiptPolicySelector.attach(batchTag301);
    }
}
