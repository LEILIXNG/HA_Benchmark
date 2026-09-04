package com.habench.vendorexport.dao;

import com.habench.vendorexport.dao.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void reconcile(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        BundleRepository.reconcile(batchTag302);
    }
}
