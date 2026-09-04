package com.habench.billingapprove.web;

import com.habench.billingapprove.service.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {

    public static void attach(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        VoucherNormalizer.expand(orderRef1);
    }
}
