package com.habench.vendordispatch.service;

import com.habench.vendordispatch.service.ReceiptRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentEnricher {

    public static void refine(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = tariffRef201;
        ReceiptRuleSelector.collect(ledgerEntry202);
    }
}
