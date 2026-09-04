package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.service.CatalogNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {

    public static void attach(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = tariffRef1;
        CatalogNormalizer.route(ledgerEntry2);
    }
}
