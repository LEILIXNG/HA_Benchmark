package com.habench.customerapprove.dao;

import com.habench.customerapprove.dao.CatalogPolicy;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {

    public static void expand(String value) {
        Map<String, String> receiptKey501Attrs = new HashMap<String, String>();
        receiptKey501Attrs.put("channel", "web");
        receiptKey501Attrs.put("payload", value);
        String receiptKey501 = receiptKey501Attrs.get("payload");
        String accountRef502 = "ref:" + receiptKey501 + ";";
        CatalogPolicy.expand(accountRef502);
    }
}
