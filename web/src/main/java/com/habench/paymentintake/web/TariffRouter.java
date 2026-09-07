package com.habench.paymentintake.web;

import com.habench.paymentintake.service.AccountAssembler;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void enrich(String value) {
        String batchTag101 = "ref:" + value + ";";
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        AccountAssembler.stage(orderRef102);
    }
}
