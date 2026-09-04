package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.SessionFacade;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {

    public static void forward(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        SessionFacade.reconcile(invoiceKey101);
    }
}
