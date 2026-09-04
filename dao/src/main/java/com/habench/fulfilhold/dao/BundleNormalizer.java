package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {

    public static void refine(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        String orderRef302 = "ref:" + batchTag301 + ";";
        BundlePolicySelector.translate(orderRef302);
    }
}
