package com.habench.reportgrant.web;

import com.habench.reportgrant.web.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {

    public static void compose(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        BundleTranslator.translate(manifestKey102);
    }
}
