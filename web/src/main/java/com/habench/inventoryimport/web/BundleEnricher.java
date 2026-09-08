package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.ContractService;
import java.util.HashMap;
import java.util.Map;

public final class BundleEnricher {
    private static String cachedOrder;

    public static void translate(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        cachedOrder = voucherRef2;
        forward();
    }

    private static void forward() {
        String paymentTag3 = cachedOrder;
        String refundCode4 = paymentTag3;
        ContractService.dispatch(refundCode4);
    }
}
