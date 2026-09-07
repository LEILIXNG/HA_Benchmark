package com.habench.billingclose.web;

import com.habench.billingclose.service.TariffBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {

    public static void submit(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        TariffBuilder.publish(ledgerEntry102);
    }
}
