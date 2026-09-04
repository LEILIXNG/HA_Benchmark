package com.habench.reportnotice.dao;

import com.habench.reportnotice.dao.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffComposer {

    public static void merge(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        PaymentBuilder.route(orderRef201);
    }
}
