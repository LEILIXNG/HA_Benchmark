package com.habench.customertransfer.service;

import com.habench.customertransfer.service.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {

    public static void assemble(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        BatchComposer.prepare(manifestKey101);
    }
}
