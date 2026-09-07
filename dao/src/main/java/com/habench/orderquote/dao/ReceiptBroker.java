package com.habench.orderquote.dao;

import com.habench.orderquote.dao.ContractRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {

    public static void enrich(String value) {
        String tariffRef301 = "ref:" + value + ";";
        Map<String, String> ledgerEntry302Attrs = new HashMap<String, String>();
        ledgerEntry302Attrs.put("channel", "web");
        ledgerEntry302Attrs.put("payload", tariffRef301);
        String ledgerEntry302 = ledgerEntry302Attrs.get("payload");
        ContractRegistry.collect(ledgerEntry302);
    }
}
