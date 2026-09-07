package com.habench.inventoryposting.service;

import com.habench.inventoryposting.service.CatalogFilter;
import java.util.HashMap;
import java.util.Map;

public final class OrderAdapter {

    public static void merge(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = "ref:" + batchTag201 + ";";
        CatalogFilter.compose(orderRef202);
    }
}
