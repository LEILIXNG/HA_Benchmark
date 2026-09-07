package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderRegistry {

    public static void register(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        LedgerStrategySelector.publish(batchTag202);
    }
}
