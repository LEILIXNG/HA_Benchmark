package com.habench.catalogreopen.web;

import com.habench.catalogreopen.service.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {

    public static void refine(String value) {
        String receiptKey1 = value;
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        ReceiptService.reconcile(accountRef2);
    }
}
