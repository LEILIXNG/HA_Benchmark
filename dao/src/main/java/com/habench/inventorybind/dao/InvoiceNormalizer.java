package com.habench.inventorybind.dao;

import com.habench.inventorybind.dao.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {

    public static void collect(String value) {
        Map<String, String> tariffRef501Attrs = new HashMap<String, String>();
        tariffRef501Attrs.put("channel", "web");
        tariffRef501Attrs.put("payload", value);
        String tariffRef501 = tariffRef501Attrs.get("payload");
        String ledgerEntry502 = tariffRef501;
        PaymentStrategySelector.collect(ledgerEntry502);
    }
}
