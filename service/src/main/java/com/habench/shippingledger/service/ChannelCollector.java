package com.habench.shippingledger.service;

import com.habench.shippingledger.dao.RefundService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {
    private static String cachedBatch;

    public static void route(String value) {
        String orderRef301 = value;
        cachedBatch = orderRef301;
        resolve();
    }

    private static void resolve() {
        String quoteRef302 = cachedBatch;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        RefundService.route(tariffRef303);
    }
}
