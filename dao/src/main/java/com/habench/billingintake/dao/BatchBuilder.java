package com.habench.billingintake.dao;

import com.habench.billingintake.dao.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {

    public static void expand(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        String shipmentCode202 = refundCode201;
        PaymentPolicySelector.expand(shipmentCode202);
    }
}
