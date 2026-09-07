package com.habench.orderreopen.service;

import com.habench.orderreopen.service.ContractComposer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {

    public static void enrich(String value) {
        Map<String, String> refundCode301Attrs = new HashMap<String, String>();
        refundCode301Attrs.put("channel", "web");
        refundCode301Attrs.put("payload", value);
        String refundCode301 = refundCode301Attrs.get("payload");
        String shipmentCode302 = refundCode301;
        ContractComposer.stage(shipmentCode302);
    }
}
