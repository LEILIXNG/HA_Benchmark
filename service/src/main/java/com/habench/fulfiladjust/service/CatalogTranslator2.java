package com.habench.fulfiladjust.service;

import com.habench.fulfiladjust.dao.CatalogTranslator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator2 {
    private String pendingOrder;
    private static String cachedOrder;

    public static void forward(String value) {
        CatalogTranslator2 self = new CatalogTranslator2();
        self.register(value);
    }

    private void register(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        cachedOrder = channelTag202;
        translate();
    }

    private void translate() {
        String catalogKey203 = cachedOrder;
        String receiptKey204 = catalogKey203;
        Map<String, String> accountRef205Attrs = new HashMap<String, String>();
        accountRef205Attrs.put("channel", "web");
        accountRef205Attrs.put("payload", receiptKey204);
        String accountRef205 = accountRef205Attrs.get("payload");
        this.pendingOrder = accountRef205;
        dispatch();
    }

    private void dispatch() {
        String voucherRef206 = this.pendingOrder;
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        CatalogTranslator.resolve(paymentTag207);
    }
}
