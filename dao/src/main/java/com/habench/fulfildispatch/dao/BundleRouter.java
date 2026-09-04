package com.habench.fulfildispatch.dao;

import com.habench.fulfildispatch.dao.ContractLoader;
import java.util.HashMap;
import java.util.Map;

public final class BundleRouter {

    public static void assemble(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = "ref:" + receiptKey301 + ";";
        ContractLoader.reconcile(accountRef302);
    }
}
