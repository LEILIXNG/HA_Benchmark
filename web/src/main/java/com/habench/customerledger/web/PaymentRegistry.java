package com.habench.customerledger.web;

import com.habench.customerledger.web.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {

    public static void submit(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        String shipmentCode2 = "ref:" + refundCode1 + ";";
        BatchPolicySelector.attach(shipmentCode2);
    }
}
