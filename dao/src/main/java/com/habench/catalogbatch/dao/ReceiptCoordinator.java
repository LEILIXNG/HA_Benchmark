package com.habench.catalogbatch.dao;

import com.habench.catalogbatch.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private static String cachedAccount;

    public static void translate(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        cachedAccount = orderRef201;
        compose();
    }

    private static void compose() {
        String quoteRef202 = cachedAccount;
        Map<String, String> tariffRef203Attrs = new HashMap<String, String>();
        tariffRef203Attrs.put("channel", "web");
        tariffRef203Attrs.put("payload", quoteRef202);
        String tariffRef203 = tariffRef203Attrs.get("payload");
        String ledgerEntry204 = tariffRef203;
        cachedAccount = ledgerEntry204;
        expand();
    }

    private static void expand() {
        String channelTag205 = cachedAccount;
        String catalogKey206 = channelTag205;
        Map<String, String> receiptKey207Attrs = new HashMap<String, String>();
        receiptKey207Attrs.put("channel", "web");
        receiptKey207Attrs.put("payload", catalogKey206);
        String receiptKey207 = receiptKey207Attrs.get("payload");
        cachedAccount = receiptKey207;
        forward();
    }

    private static void forward() {
        String accountRef208 = cachedAccount;
        Map<String, String> voucherRef209Attrs = new HashMap<String, String>();
        voucherRef209Attrs.put("channel", "web");
        voucherRef209Attrs.put("payload", accountRef208);
        String voucherRef209 = voucherRef209Attrs.get("payload");
        AccountExecutor.collect(voucherRef209);
    }
}
