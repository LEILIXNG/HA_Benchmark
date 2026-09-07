package com.habench.paymentimport.web;

import com.habench.paymentimport.service.AccountRouter;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {

    public static void translate(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        AccountRouter.resolve(quoteRef2);
    }
}
