package com.habench.customermerge.dao;

import com.habench.customermerge.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {

    public static void stage(String value) {
        String accountRef401 = value;
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("payload", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("payload");
        AccountExecutor.normalize(voucherRef402);
    }
}
