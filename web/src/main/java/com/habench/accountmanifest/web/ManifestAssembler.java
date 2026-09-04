package com.habench.accountmanifest.web;

import com.habench.accountmanifest.service.LedgerComposer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {

    public static void publish(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = catalogKey1;
        LedgerComposer.refine(receiptKey2);
    }
}
