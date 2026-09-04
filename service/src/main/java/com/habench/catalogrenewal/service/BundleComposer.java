package com.habench.catalogrenewal.service;

import com.habench.catalogrenewal.dao.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        ManifestService.assemble(ledgerEntry101);
    }
}
