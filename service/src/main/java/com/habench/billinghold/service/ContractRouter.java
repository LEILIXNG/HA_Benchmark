package com.habench.billinghold.service;

import com.habench.billinghold.service.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {

    public static void attach(String value) {
        String tariffRef501 = "ref:" + value + ";";
        Map<String, String> ledgerEntry502Attrs = new HashMap<String, String>();
        ledgerEntry502Attrs.put("channel", "web");
        ledgerEntry502Attrs.put("payload", tariffRef501);
        String ledgerEntry502 = ledgerEntry502Attrs.get("payload");
        ReceiptExecutor.forward(ledgerEntry502);
    }
}
