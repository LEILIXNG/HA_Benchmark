package com.habench.fulfildraft.service;

import com.habench.fulfildraft.service.SessionTranslator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {

    public static void enrich(String value) {
        String receiptKey201 = value;
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        SessionTranslator.reconcile(accountRef202);
    }
}
