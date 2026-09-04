package com.habench.catalogdraft.web;

import com.habench.catalogdraft.service.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {
    private static String cachedOrder;

    public static void refine(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        cachedOrder = receiptKey1;
        submit();
    }

    private static void submit() {
        String accountRef2 = cachedOrder;
        String voucherRef3 = accountRef2;
        String paymentTag4 = voucherRef3;
        ShipmentService.submit(paymentTag4);
    }
}
