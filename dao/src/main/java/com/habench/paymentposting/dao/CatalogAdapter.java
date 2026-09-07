package com.habench.paymentposting.dao;

import com.habench.paymentposting.dao.ContractRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {

    public static void reconcile(String value) {
        Map<String, String> tariffRef501Attrs = new HashMap<String, String>();
        tariffRef501Attrs.put("channel", "web");
        tariffRef501Attrs.put("payload", value);
        String tariffRef501 = tariffRef501Attrs.get("payload");
        String ledgerEntry502 = tariffRef501;
        ContractRuleSelector.forward(ledgerEntry502);
    }
}
