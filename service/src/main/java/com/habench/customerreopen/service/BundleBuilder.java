package com.habench.customerreopen.service;

import com.habench.customerreopen.service.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {

    public static void forward(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        TariffEnricher.normalize(catalogKey201);
    }
}
