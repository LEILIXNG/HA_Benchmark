package com.habench.reportarchive.web;

import com.habench.reportarchive.service.ShipmentResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator2 {

    public static void normalize(String value) {
        String accountRef1 = value;
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        ShipmentResolver.enrich(voucherRef2);
    }
}
