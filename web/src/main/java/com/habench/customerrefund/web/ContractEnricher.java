package com.habench.customerrefund.web;

import com.habench.customerrefund.service.ChannelTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void publish(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        ChannelTranslator.merge(voucherRef101);
    }
}
