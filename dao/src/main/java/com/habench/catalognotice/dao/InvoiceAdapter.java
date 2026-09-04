package com.habench.catalognotice.dao;

import com.habench.catalognotice.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {

    public static void refine(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        OrderRepository.reconcile(accountRef202);
    }
}
