package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.service.ChannelRegistry;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {

    public static void register(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        ChannelRegistry.refine(manifestKey302);
    }
}
