package com.habench.fulfilrollup.service;

import com.habench.fulfilrollup.service.PaymentFilter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {

    public static void publish(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        PaymentFilter.route(accountRef101);
    }
}
