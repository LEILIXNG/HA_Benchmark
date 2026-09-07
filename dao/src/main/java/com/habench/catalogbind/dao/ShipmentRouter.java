package com.habench.catalogbind.dao;

import com.habench.catalogbind.dao.InvoiceValidator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void forward(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        InvoiceValidator.attach(shipmentCode201);
    }
}
