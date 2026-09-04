package com.habench.fulfilbind.dao;

import com.habench.fulfilbind.dao.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {

    public static void collect(String value) {
        Map<String, String> manifestKey501Attrs = new HashMap<String, String>();
        manifestKey501Attrs.put("channel", "web");
        manifestKey501Attrs.put("payload", value);
        String manifestKey501 = manifestKey501Attrs.get("payload");
        String invoiceKey502 = manifestKey501;
        LedgerRepository.dispatch(invoiceKey502);
    }
}
