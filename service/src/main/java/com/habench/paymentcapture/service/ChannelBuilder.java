package com.habench.paymentcapture.service;

import com.habench.paymentcapture.dao.PaymentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {

    public static void enrich(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        String voucherRef102 = accountRef101;
        PaymentAdapter.expand(voucherRef102);
    }
}
