package com.habench.accountverify.dao;

import com.habench.accountverify.dao.ContractRegistry;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {

    public static void collect(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        String catalogKey302 = "ref:" + channelTag301 + ";";
        ContractRegistry.submit(catalogKey302);
    }
}
