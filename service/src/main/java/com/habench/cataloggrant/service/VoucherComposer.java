package com.habench.cataloggrant.service;

import com.habench.cataloggrant.service.QuoteGuard;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void merge(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        QuoteGuard.route(accountRef201);
    }
}
