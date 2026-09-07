package com.habench.accountexport.dao;

import com.habench.accountexport.dao.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {
    private static String cachedPayment;

    public static void publish(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        String channelTag302 = ledgerEntry301;
        cachedPayment = channelTag302;
        dispatch();
    }

    private static void dispatch() {
        String catalogKey303 = cachedPayment;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        cachedPayment = receiptKey304;
        merge();
    }

    private static void merge() {
        String accountRef305 = cachedPayment;
        String voucherRef306 = "ref:" + accountRef305 + ";";
        PaymentLoader.forward(voucherRef306);
    }
}
