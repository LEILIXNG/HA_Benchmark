package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.AccountAssembler;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {

    public static void route(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = "ref:" + orderRef1 + ";";
        AccountAssembler.expand(quoteRef2);
    }
}
