package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.TariffLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {

    public static void resolve(String value) {
        String batchTag101 = value;
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        TariffLoader.attach(orderRef102);
    }
}
