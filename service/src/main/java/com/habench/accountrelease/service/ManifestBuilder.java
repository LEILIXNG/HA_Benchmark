package com.habench.accountrelease.service;

import com.habench.accountrelease.dao.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBuilder {

    public static void expand(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        String manifestKey102 = shipmentCode101;
        OrderComposer.stage(manifestKey102);
    }
}
