package com.habench.vendorreopen.service;

import com.habench.vendorreopen.service.QuotePolicy;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {

    public static void dispatch(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = invoiceKey201;
        QuotePolicy.expand(batchTag202);
    }
}
