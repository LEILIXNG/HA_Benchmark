package com.habench.catalogadjust.web;

import com.habench.catalogadjust.service.VoucherCollector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {

    public static void prepare(String value) {
        String accountRef101 = value;
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        VoucherCollector.expand(voucherRef102);
    }
}
