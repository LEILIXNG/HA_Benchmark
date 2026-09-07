package com.habench.catalogsplit.service;

import com.habench.catalogsplit.dao.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {

    public static void forward(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        ManifestRouter.merge(receiptKey301);
    }
}
