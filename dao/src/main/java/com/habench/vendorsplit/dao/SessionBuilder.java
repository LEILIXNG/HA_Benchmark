package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.LedgerBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void stage(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        String paymentTag302 = "ref:" + voucherRef301 + ";";
        LedgerBuilder.reconcile(paymentTag302);
    }
}
