package com.habench.billingtransfer.service;

import com.habench.billingtransfer.dao.ManifestNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {

    public static void collect(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = paymentTag301;
        ManifestNormalizer.publish(refundCode302);
    }
}
