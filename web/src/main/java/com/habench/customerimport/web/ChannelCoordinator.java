package com.habench.customerimport.web;

import com.habench.customerimport.web.AccountRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private static String cachedAccount;

    public static void normalize(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedAccount = quoteRef1;
        route();
    }

    private static void route() {
        String tariffRef2 = cachedAccount;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        String channelTag4 = ledgerEntry3;
        cachedAccount = channelTag4;
        merge();
    }

    private static void merge() {
        String catalogKey5 = cachedAccount;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("payload", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("payload");
        String accountRef7 = receiptKey6;
        AccountRepository.expand(accountRef7);
    }
}
