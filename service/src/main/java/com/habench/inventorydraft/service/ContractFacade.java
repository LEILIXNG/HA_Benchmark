package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.InvoiceGateway;
import java.util.HashMap;
import java.util.Map;

public final class ContractFacade {

    public static void resolve(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        InvoiceGateway.submit(quoteRef201);
    }
}
