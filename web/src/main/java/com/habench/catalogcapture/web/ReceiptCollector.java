package com.habench.catalogcapture.web;

import com.habench.catalogcapture.web.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {

    public static void assemble(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = voucherRef1;
        BatchPolicySelector.forward(paymentTag2);
    }
}
