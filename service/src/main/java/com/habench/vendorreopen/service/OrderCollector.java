package com.habench.vendorreopen.service;

import com.habench.vendorreopen.dao.TariffFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void assemble(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        TariffFacade.resolve(orderRef201);
    }
}
