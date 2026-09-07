package com.habench.fulfilreopen.service;

import com.habench.fulfilreopen.dao.BatchBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {

    public static void resolve(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        BatchBuilder.refine(orderRef302);
    }
}
