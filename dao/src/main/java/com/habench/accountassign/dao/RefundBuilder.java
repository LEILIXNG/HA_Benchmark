package com.habench.accountassign.dao;

import com.habench.accountassign.dao.ManifestEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {

    public static void attach(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        ManifestEvaluator.resolve(refundCode201);
    }
}
