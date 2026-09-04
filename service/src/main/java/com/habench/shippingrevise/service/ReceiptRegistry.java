package com.habench.shippingrevise.service;

import com.habench.shippingrevise.service.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {

    public static void attach(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        InvoicePlanSelector.merge(invoiceKey202);
    }
}
