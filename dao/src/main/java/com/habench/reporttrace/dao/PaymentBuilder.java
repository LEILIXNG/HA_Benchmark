package com.habench.reporttrace.dao;

import com.habench.reporttrace.dao.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void prepare(String value) {
        Map<String, String> accountRef701Attrs = new HashMap<String, String>();
        accountRef701Attrs.put("channel", "web");
        accountRef701Attrs.put("payload", value);
        String accountRef701 = accountRef701Attrs.get("payload");
        String voucherRef702 = "ref:" + accountRef701 + ";";
        SessionEvaluator.refine(voucherRef702);
    }
}
