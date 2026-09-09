package com.habench.orderarchive.service;

import com.habench.orderarchive.service.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void publish(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = voucherRef201;
        ContractStrategySelector.expand(paymentTag202);
    }
}
