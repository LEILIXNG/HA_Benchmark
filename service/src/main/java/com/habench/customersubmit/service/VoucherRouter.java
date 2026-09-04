package com.habench.customersubmit.service;

import com.habench.customersubmit.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private static String cachedCatalog;

    public static void submit(String value) {
        String receiptKey401 = "ref:" + value + ";";
        Map<String, String> accountRef402Attrs = new HashMap<String, String>();
        accountRef402Attrs.put("channel", "web");
        accountRef402Attrs.put("payload", receiptKey401);
        String accountRef402 = accountRef402Attrs.get("payload");
        cachedCatalog = accountRef402;
        enrich();
    }

    private static void enrich() {
        String voucherRef403 = cachedCatalog;
        String paymentTag404 = voucherRef403;
        InvoiceRegistry.attach(paymentTag404);
    }
}
