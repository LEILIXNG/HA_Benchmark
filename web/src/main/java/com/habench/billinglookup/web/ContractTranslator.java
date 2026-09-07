package com.habench.billinglookup.web;

import com.habench.billinglookup.service.SessionBroker;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {
    private static String cachedAccount;

    public static void submit(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        cachedAccount = quoteRef2;
        route();
    }

    private static void route() {
        String tariffRef3 = cachedAccount;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        cachedAccount = channelTag5;
        register();
    }

    private static void register() {
        String catalogKey6 = cachedAccount;
        String receiptKey7 = "ref:" + catalogKey6 + ";";
        Map<String, String> accountRef8Attrs = new HashMap<String, String>();
        accountRef8Attrs.put("channel", "web");
        accountRef8Attrs.put("payload", receiptKey7);
        String accountRef8 = accountRef8Attrs.get("payload");
        SessionBroker.compose(accountRef8);
    }
}
