package com.habench.customerdispatch.service;

import com.habench.customerdispatch.service.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {

    public static void refine(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        BundleRepository.stage(ledgerEntry201);
    }
}
