package com.habench.inventorydispatch.dao;

import com.habench.inventorydispatch.dao.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {

    public static void attach(String value) {
        Map<String, String> manifestKey501Attrs = new HashMap<String, String>();
        manifestKey501Attrs.put("channel", "web");
        manifestKey501Attrs.put("payload", value);
        String manifestKey501 = manifestKey501Attrs.get("payload");
        Map<String, String> invoiceKey502Attrs = new HashMap<String, String>();
        invoiceKey502Attrs.put("channel", "web");
        invoiceKey502Attrs.put("payload", manifestKey501);
        String invoiceKey502 = invoiceKey502Attrs.get("payload");
        PaymentLoader.forward(invoiceKey502);
    }
}
