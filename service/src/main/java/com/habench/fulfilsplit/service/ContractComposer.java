package com.habench.fulfilsplit.service;

import com.habench.fulfilsplit.dao.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {

    public static void attach(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        ManifestFacade.route(manifestKey101);
    }
}
