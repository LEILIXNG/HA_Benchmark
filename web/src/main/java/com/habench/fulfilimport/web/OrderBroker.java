package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.BundleService;
import java.util.HashMap;
import java.util.Map;

public final class OrderBroker {

    public static void compose(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        BundleService.submit(batchTag1);
    }
}
