package com.habench.accountarchive.service;

import com.habench.accountarchive.service.OrderBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BatchService {

    public static void normalize(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        OrderBuilder.route(voucherRef202);
    }
}
