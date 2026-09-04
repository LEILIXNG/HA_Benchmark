package com.habench.shippingclose.web;

import com.habench.shippingclose.web.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRouter {

    public static void attach(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = quoteRef1;
        ChannelNormalizer.prepare(tariffRef2);
    }
}
