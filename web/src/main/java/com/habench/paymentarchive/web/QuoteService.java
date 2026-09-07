package com.habench.paymentarchive.web;

import com.habench.paymentarchive.service.BatchFacade;
import java.util.HashMap;
import java.util.Map;

public final class QuoteService {

    public static void translate(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        BatchFacade.forward(batchTag1);
    }
}
