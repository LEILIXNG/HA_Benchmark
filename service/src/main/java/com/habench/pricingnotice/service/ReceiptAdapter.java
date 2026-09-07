package com.habench.pricingnotice.service;

import com.habench.pricingnotice.dao.AccountEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {

    public static void compose(String value) {
        String batchTag101 = "ref:" + value + ";";
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        AccountEnricher.expand(orderRef102);
    }
}
