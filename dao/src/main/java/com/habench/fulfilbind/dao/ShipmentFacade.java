package com.habench.fulfilbind.dao;

import com.habench.fulfilbind.dao.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void forward(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        LedgerPolicySelector.resolve(receiptKey202);
    }
}
