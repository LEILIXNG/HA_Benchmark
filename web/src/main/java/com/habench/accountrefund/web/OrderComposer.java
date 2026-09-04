package com.habench.accountrefund.web;

import com.habench.accountrefund.web.PaymentService;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {

    public static void submit(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        PaymentService.translate(quoteRef2);
    }
}
