package com.habench.customerarchive.service;

import com.habench.customerarchive.dao.SessionTranslator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private static String cachedSession;

    public static void publish(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        cachedSession = receiptKey202;
        refine();
    }

    private static void refine() {
        String accountRef203 = cachedSession;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        String paymentTag205 = "ref:" + voucherRef204 + ";";
        SessionTranslator.compose(paymentTag205);
    }
}
