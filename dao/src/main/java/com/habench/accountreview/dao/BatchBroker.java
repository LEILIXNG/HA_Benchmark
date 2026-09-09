package com.habench.accountreview.dao;

import com.habench.accountreview.dao.CatalogRepository;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {

    public static void attach(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        CatalogRepository.submit(voucherRef301);
    }
}
