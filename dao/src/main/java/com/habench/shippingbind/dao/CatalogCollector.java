package com.habench.shippingbind.dao;

import com.habench.shippingbind.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {

    public static void dispatch(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        Map<String, String> refundCode402Attrs = new HashMap<String, String>();
        refundCode402Attrs.put("channel", "web");
        refundCode402Attrs.put("payload", paymentTag401);
        String refundCode402 = refundCode402Attrs.get("payload");
        OrderExecutor.resolve(refundCode402);
    }
}
