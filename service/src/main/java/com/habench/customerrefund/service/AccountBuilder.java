package com.habench.customerrefund.service;

import com.habench.customerrefund.service.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {

    public static void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = invoiceKey201;
        TariffNormalizer.resolve(batchTag202);
    }
}
