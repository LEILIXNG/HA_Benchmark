package com.habench.paymentsubmit.dao;

import com.habench.paymentsubmit.dao.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerEnricher {

    public static void compose(String value) {
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("payload", value);
        String voucherRef501 = voucherRef501Attrs.get("payload");
        SessionEvaluator.assemble(voucherRef501);
    }
}
