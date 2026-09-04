package com.habench.shippingarchive.dao;

import com.habench.shippingarchive.dao.LedgerGuard;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {

    public static void dispatch(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("payload", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("payload");
        LedgerGuard.resolve(quoteRef302);
    }
}
