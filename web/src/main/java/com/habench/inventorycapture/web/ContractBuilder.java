package com.habench.inventorycapture.web;

import com.habench.inventorycapture.service.CatalogService;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void assemble(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        CatalogService.assemble(invoiceKey2);
    }
}
