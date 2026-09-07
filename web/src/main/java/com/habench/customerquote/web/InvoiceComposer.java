package com.habench.customerquote.web;

import com.habench.customerquote.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {

    public static void compose(String value) {
        String shipmentCode1 = value;
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        AccountPolicySelector.expand(manifestKey2);
    }
}
