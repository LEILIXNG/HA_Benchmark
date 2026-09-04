package com.habench.catalogdraft.service;

import com.habench.catalogdraft.service.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {

    public static void route(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        OrderRepository.submit(manifestKey202);
    }
}
