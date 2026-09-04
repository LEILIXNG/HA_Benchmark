package com.habench.customeradjust.web;

import com.habench.customeradjust.service.ReceiptResolver;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {

    public static void expand(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        ReceiptResolver.resolve(orderRef1);
    }
}
