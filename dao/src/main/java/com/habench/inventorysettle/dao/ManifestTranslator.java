package com.habench.inventorysettle.dao;

import com.habench.inventorysettle.dao.ContractValidator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {

    public static void normalize(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        ContractValidator.forward(manifestKey401);
    }
}
