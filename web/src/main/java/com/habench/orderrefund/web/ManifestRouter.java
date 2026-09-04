package com.habench.orderrefund.web;

import com.habench.orderrefund.service.TariffRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {

    public static void dispatch(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        TariffRouter.reconcile(voucherRef102);
    }
}
