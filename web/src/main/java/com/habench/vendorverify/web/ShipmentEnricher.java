package com.habench.vendorverify.web;

import com.habench.vendorverify.service.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void expand(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        CatalogAdapter.compose(voucherRef202);
    }
}
