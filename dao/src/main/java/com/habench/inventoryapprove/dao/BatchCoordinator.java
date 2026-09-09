package com.habench.inventoryapprove.dao;

import com.habench.inventoryapprove.dao.BatchFilter;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {

    public static void compose(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        String accountRef402 = "ref:" + receiptKey401 + ";";
        BatchFilter.enrich(accountRef402);
    }
}
