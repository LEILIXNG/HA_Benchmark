package com.habench.reportposting.web;

import com.habench.reportposting.service.PaymentFacade;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private static String cachedManifest;

    public static void register(String value) {
        String receiptKey1 = "ref:" + value + ";";
        cachedManifest = receiptKey1;
        normalize();
    }

    private static void normalize() {
        String accountRef2 = cachedManifest;
        Map<String, String> voucherRef3Attrs = new HashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("payload", accountRef2);
        String voucherRef3 = voucherRef3Attrs.get("payload");
        PaymentFacade.forward(voucherRef3);
    }
}
