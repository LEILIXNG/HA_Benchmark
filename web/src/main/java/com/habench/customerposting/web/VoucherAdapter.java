package com.habench.customerposting.web;

import com.habench.customerposting.service.RefundNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {

    public static void forward(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        RefundNormalizer.publish(quoteRef102);
    }
}
