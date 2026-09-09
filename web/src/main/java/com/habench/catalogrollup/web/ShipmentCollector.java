package com.habench.catalogrollup.web;

import com.habench.catalogrollup.web.ContractPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private static String cachedContract;

    public static void expand(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        cachedContract = accountRef1;
        forward();
    }

    private static void forward() {
        String voucherRef2 = cachedContract;
        String paymentTag3 = voucherRef2;
        ContractPlanSelector.stage(paymentTag3);
    }
}
