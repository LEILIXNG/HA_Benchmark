package com.habench.paymenthold.dao;

import com.habench.paymenthold.dao.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void forward(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        BundlePolicySelector.compose(batchTag401);
    }
}
