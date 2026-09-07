package com.habench.fulfilsync.service;

import com.habench.fulfilsync.dao.LedgerComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void normalize(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        LedgerComposer.translate(accountRef201);
    }
}
