package com.habench.inventorymanifest.service;

import com.habench.inventorymanifest.service.CatalogRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {

    public static void publish(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        CatalogRepository.stage(shipmentCode201);
    }
}
