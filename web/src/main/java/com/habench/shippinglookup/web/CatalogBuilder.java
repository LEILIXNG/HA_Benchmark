package com.habench.shippinglookup.web;

import com.habench.shippinglookup.service.PaymentAssembler;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {

    public static void prepare(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        PaymentAssembler.assemble(shipmentCode1);
    }
}
