package com.habench.paymentarchive.dao;

import com.habench.paymentarchive.dao.ContractGuard;
import java.util.HashMap;
import java.util.Map;

public final class SessionComposer {

    public static void collect(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        String orderRef302 = "ref:" + batchTag301 + ";";
        ContractGuard.reconcile(orderRef302);
    }
}
