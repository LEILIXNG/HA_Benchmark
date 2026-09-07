package com.habench.billingreview.service;

import com.habench.billingreview.dao.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerFacade {

    public static void collect(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        CatalogBuilder.merge(refundCode101);
    }
}
