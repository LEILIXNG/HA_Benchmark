package com.habench.reporttransfer.dao;

import com.habench.reporttransfer.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {

    public static void prepare(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        BatchExecutor.publish(receiptKey201);
    }
}
