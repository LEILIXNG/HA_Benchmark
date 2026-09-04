package com.habench.paymentsettlequeue.service;

import com.habench.paymentsettlequeue.dao.PaymentCollector;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private static String cachedSession;

    public static void assemble(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        cachedSession = catalogKey101;
        forward();
    }

    private static void forward() {
        String receiptKey102 = cachedSession;
        String accountRef103 = "ref:" + receiptKey102 + ";";
        Map<String, String> voucherRef104Attrs = new HashMap<String, String>();
        voucherRef104Attrs.put("channel", "web");
        voucherRef104Attrs.put("payload", accountRef103);
        String voucherRef104 = voucherRef104Attrs.get("payload");
        PaymentCollector.attach(voucherRef104);
    }
}
