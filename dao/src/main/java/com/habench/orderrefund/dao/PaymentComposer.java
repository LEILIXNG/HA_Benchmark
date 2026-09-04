package com.habench.orderrefund.dao;

import com.habench.orderrefund.dao.PaymentPolicy;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {

    public static void register(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("payload", value);
        String accountRef401 = accountRef401Attrs.get("payload");
        String voucherRef402 = accountRef401;
        PaymentPolicy.attach(voucherRef402);
    }
}
