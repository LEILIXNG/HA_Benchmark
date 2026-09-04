package com.habench.paymentquote.web;

import com.habench.paymentquote.web.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private static String cachedChannel;

    public static void route(String value) {
        String tariffRef1 = "ref:" + value + ";";
        cachedChannel = tariffRef1;
        normalize();
    }

    private static void normalize() {
        String ledgerEntry2 = cachedChannel;
        String channelTag3 = ledgerEntry2;
        String catalogKey4 = channelTag3;
        cachedChannel = catalogKey4;
        submit();
    }

    private static void submit() {
        String receiptKey5 = cachedChannel;
        Map<String, String> accountRef6Attrs = new HashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("payload", receiptKey5);
        String accountRef6 = accountRef6Attrs.get("payload");
        InvoiceNormalizer.submit(accountRef6);
    }
}
