package com.habench.accountimport.service;

import com.habench.accountimport.service.BundleRouter;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {

    public static void assemble(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        BundleRouter.enrich(shipmentCode102);
    }
}
