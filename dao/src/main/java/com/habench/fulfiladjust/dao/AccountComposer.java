package com.habench.fulfiladjust.dao;

import com.habench.fulfiladjust.dao.CatalogScreen;
import java.util.HashMap;
import java.util.Map;

public final class AccountComposer {

    public static void reconcile(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        CatalogScreen.reconcile(manifestKey302);
    }
}
