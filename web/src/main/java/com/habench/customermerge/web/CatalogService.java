package com.habench.customermerge.web;

import com.habench.customermerge.service.OrderService;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {
    private static String cachedAccount;

    public static void dispatch(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        cachedAccount = accountRef1;
        collect();
    }

    private static void collect() {
        String voucherRef2 = cachedAccount;
        String paymentTag3 = voucherRef2;
        String refundCode4 = paymentTag3;
        OrderService.expand(refundCode4);
    }
}
