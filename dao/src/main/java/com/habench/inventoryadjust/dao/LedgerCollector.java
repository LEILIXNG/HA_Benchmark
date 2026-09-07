package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.ManifestScreen;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCollector {

    public static void compose(String value) {
        String quoteRef201 = value;
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        ManifestScreen.resolve(tariffRef202);
    }
}
