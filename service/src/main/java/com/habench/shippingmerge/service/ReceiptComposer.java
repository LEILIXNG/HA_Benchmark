package com.habench.shippingmerge.service;

import com.habench.shippingmerge.dao.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {

    public static void register(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        String orderRef102 = "ref:" + batchTag101 + ";";
        QuoteRouter.submit(orderRef102);
    }
}
