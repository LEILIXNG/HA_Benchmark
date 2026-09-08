package com.habench.vendorapprove.web;

import com.habench.vendorapprove.service.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {

    public static void resolve(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        TariffNormalizer.merge(ledgerEntry2);
    }
}
