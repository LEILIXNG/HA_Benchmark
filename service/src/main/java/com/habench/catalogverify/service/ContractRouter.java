package com.habench.catalogverify.service;

import com.habench.catalogverify.dao.BundleService;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {
    private static String cachedChannel;

    public static void publish(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        cachedChannel = catalogKey101;
        route();
    }

    private static void route() {
        String receiptKey102 = cachedChannel;
        String accountRef103 = receiptKey102;
        Map<String, String> voucherRef104Attrs = new HashMap<String, String>();
        voucherRef104Attrs.put("channel", "web");
        voucherRef104Attrs.put("payload", accountRef103);
        String voucherRef104 = voucherRef104Attrs.get("payload");
        BundleService.submit(voucherRef104);
    }
}
