package com.habench.paymentsettle.web;

import com.habench.paymentsettle.service.SessionAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ContractAssembler {

    public static void reconcile(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        SessionAdapter.prepare(ledgerEntry301);
    }
}
