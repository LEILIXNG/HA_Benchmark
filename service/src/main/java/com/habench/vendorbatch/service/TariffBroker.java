package com.habench.vendorbatch.service;

import com.habench.vendorbatch.service.RefundRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {

    public static void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = orderRef101;
        RefundRepository.normalize(quoteRef102);
    }
}
