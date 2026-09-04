package com.habench.accountissue.dao;

import com.habench.accountissue.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBuilder {

    public static void translate(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        RefundExecutor.expand(receiptKey401);
    }
}
