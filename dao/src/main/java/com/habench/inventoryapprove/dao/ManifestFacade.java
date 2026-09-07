package com.habench.inventoryapprove.dao;

import com.habench.inventoryapprove.dao.CatalogExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {

    public static void stage(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        CatalogExecutor.normalize(shipmentCode402);
    }
}
