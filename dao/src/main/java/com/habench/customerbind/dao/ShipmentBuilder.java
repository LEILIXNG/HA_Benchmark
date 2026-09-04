package com.habench.customerbind.dao;

import com.habench.customerbind.dao.SessionAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private static String cachedVoucher;

    public static void forward(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        String manifestKey402 = "ref:" + shipmentCode401 + ";";
        cachedVoucher = manifestKey402;
        attach();
    }

    private static void attach() {
        String invoiceKey403 = cachedVoucher;
        String batchTag404 = invoiceKey403;
        String orderRef405 = batchTag404;
        SessionAssembler.merge(orderRef405);
    }
}
