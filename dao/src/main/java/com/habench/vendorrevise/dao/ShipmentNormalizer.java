package com.habench.vendorrevise.dao;

import com.habench.vendorrevise.dao.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentNormalizer {
    private String pendingOrder;

    public static void translate(String value) {
        ShipmentNormalizer self = new ShipmentNormalizer();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        this.pendingOrder = catalogKey301;
        dispatch();
    }

    private void dispatch() {
        String receiptKey302 = this.pendingOrder;
        String accountRef303 = receiptKey302;
        AccountStrategySelector.submit(accountRef303);
    }
}
