package com.habench.reportsubmit.dao;

import com.habench.reportsubmit.dao.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {

    public static void resolve(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = "ref:" + receiptKey301 + ";";
        QuoteBuilder.stage(accountRef302);
    }
}
