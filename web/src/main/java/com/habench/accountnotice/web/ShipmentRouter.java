package com.habench.accountnotice.web;

import com.habench.accountnotice.web.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void expand(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        TariffPolicySelector.refine(invoiceKey102);
    }
}
