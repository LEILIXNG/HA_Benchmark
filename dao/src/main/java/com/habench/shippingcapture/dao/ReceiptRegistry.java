package com.habench.shippingcapture.dao;

import com.habench.shippingcapture.dao.AccountPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {

    public static void enrich(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("payload", value);
        String accountRef401 = accountRef401Attrs.get("payload");
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("payload", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("payload");
        AccountPlanSelector.translate(voucherRef402);
    }
}
