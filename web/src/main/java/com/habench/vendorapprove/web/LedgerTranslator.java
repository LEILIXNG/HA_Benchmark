package com.habench.vendorapprove.web;

import com.habench.vendorapprove.web.VoucherCollector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {

    public static void translate(String value) {
        String receiptKey1 = value;
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        VoucherCollector.expand(accountRef2);
    }
}
