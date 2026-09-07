package com.habench.accountreopen.service;

import com.habench.accountreopen.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private static String cachedSession;

    public static void resolve(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedSession = channelTag202;
        dispatch();
    }

    private static void dispatch() {
        String catalogKey203 = cachedSession;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        String accountRef205 = "ref:" + receiptKey204 + ";";
        InvoiceRuleSelector.resolve(accountRef205);
    }
}
