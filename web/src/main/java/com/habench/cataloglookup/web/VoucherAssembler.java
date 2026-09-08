package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {
    private static String cachedShipment;

    public static void submit(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedShipment = shipmentCode1;
        prepare();
    }

    private static void prepare() {
        String manifestKey2 = cachedShipment;
        String invoiceKey3 = "ref:" + manifestKey2 + ";";
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("payload", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("payload");
        ShipmentGateway.forward(batchTag4);
    }
}
