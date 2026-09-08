package com.habench.billingintake.web;

import com.habench.billingintake.service.BundleFacade;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {

    public static void compose(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        BundleFacade.submit(catalogKey1);
    }
}
