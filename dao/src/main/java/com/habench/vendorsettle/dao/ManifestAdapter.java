package com.habench.vendorsettle.dao;

import com.habench.vendorsettle.dao.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {

    public static void collect(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        LedgerRepository.dispatch(quoteRef401);
    }
}
