package com.habench.ordermanifest.web;

import com.habench.ordermanifest.web.LedgerBroker;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {

    public static void translate(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        LedgerBroker.prepare(manifestKey2);
    }
}
