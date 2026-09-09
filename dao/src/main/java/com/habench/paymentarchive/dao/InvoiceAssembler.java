package com.habench.paymentarchive.dao;

import com.habench.paymentarchive.dao.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {

    public static void register(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        ReceiptComposer.merge(ledgerEntry201);
    }
}
