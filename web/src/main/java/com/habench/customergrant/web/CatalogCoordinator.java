package com.habench.customergrant.web;

import com.habench.customergrant.service.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {

    public static void forward(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        QuoteAssembler.assemble(ledgerEntry2);
    }
}
