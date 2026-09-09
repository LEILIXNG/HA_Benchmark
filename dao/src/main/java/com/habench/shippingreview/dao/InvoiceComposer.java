package com.habench.shippingreview.dao;

import com.habench.shippingreview.dao.ReceiptStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {

    public static void translate(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        ReceiptStrategySelector.compose(catalogKey301);
    }
}
