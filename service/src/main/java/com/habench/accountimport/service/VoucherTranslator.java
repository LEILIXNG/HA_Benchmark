package com.habench.accountimport.service;

import com.habench.accountimport.service.ManifestCollector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {

    public static void register(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = quoteRef201;
        ManifestCollector.normalize(tariffRef202);
    }
}
