package com.habench.vendorquote.web;

import com.habench.vendorquote.web.LedgerAssembler;
import java.util.HashMap;
import java.util.Map;

public final class CatalogComposer {

    public static void translate(String value) {
        String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        LedgerAssembler.attach(accountRef102);
    }
}
