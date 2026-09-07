package com.habench.catalogledger.web;

import com.habench.catalogledger.web.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentNormalizer {

    public static void publish(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        VoucherStrategySelector.prepare(accountRef1);
    }
}
