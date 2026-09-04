package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.ContractLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {

    public static void compose(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        String refundCode102 = "ref:" + paymentTag101 + ";";
        ContractLoader.attach(refundCode102);
    }
}
