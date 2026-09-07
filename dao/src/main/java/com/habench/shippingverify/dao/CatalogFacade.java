package com.habench.shippingverify.dao;

import com.habench.shippingverify.dao.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void translate(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        OrderLoader.submit(receiptKey201);
    }
}
