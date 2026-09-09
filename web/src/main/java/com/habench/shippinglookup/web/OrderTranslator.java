package com.habench.shippinglookup.web;

import com.habench.shippinglookup.service.RefundRouter;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {

    public static void normalize(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        RefundRouter.compose(quoteRef101);
    }
}
