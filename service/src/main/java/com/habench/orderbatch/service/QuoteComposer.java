package com.habench.orderbatch.service;

import com.habench.orderbatch.service.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void normalize(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        String voucherRef102 = accountRef101;
        LedgerPlanSelector.prepare(voucherRef102);
    }
}
