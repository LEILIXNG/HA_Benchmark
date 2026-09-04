package com.habench.paymentdraft.web;

import com.habench.paymentdraft.service.InvoiceFacade;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {

    public static void submit(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        InvoiceFacade.enrich(accountRef2);
    }
}
