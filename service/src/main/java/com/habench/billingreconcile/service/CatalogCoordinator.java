package com.habench.billingreconcile.service;

import com.habench.billingreconcile.dao.InvoiceRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private static String cachedPayment;

    public static void stage(String value) {
        String ledgerEntry201 = value;
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedPayment = channelTag202;
        expand();
    }

    private static void expand() {
        String catalogKey203 = cachedPayment;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        Map<String, String> accountRef205Attrs = new HashMap<String, String>();
        accountRef205Attrs.put("channel", "web");
        accountRef205Attrs.put("payload", receiptKey204);
        String accountRef205 = accountRef205Attrs.get("payload");
        InvoiceRouter.publish(accountRef205);
    }
}
