package com.habench.billinghold.service;

import com.habench.billinghold.service.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {

    public static void attach(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        String voucherRef102 = "ref:" + accountRef101 + ";";
        ReceiptExecutor.forward(voucherRef102);
    }
}
