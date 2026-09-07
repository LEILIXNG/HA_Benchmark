package com.habench.inventorysettle.web;

import com.habench.inventorysettle.web.InvoiceAssembler;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {

    public static void register(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        InvoiceAssembler.publish(ledgerEntry2);
    }
}
