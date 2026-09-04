package com.habench.shippingmerge.web;

import com.habench.shippingmerge.web.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {

    public static void refine(String value) {
        String receiptKey1 = "ref:" + value + ";";
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        ChannelBuilder.merge(accountRef2);
    }
}
