package com.habench.catalogcapture.dao;

import com.habench.catalogcapture.dao.CatalogFetcher;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {

    public static void translate(String value) {
        String voucherRef301 = value;
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        CatalogFetcher.compose(paymentTag302);
    }
}
