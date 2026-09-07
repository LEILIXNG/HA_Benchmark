package com.habench.paymentapprove.web;

import com.habench.paymentapprove.service.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void assemble(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        VoucherEnricher.dispatch(orderRef1);
    }
}
