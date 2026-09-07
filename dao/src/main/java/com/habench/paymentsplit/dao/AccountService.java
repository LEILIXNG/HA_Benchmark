package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {

    public static void stage(String value) {
        Map<String, String> batchTag601Attrs = new HashMap<String, String>();
        batchTag601Attrs.put("channel", "web");
        batchTag601Attrs.put("payload", value);
        String batchTag601 = batchTag601Attrs.get("payload");
        RefundExecutor.forward(batchTag601);
    }
}
