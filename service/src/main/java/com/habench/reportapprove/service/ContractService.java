package com.habench.reportapprove.service;

import com.habench.reportapprove.service.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {

    public static void route(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        String refundCode402 = paymentTag401;
        TariffBroker.submit(refundCode402);
    }
}
