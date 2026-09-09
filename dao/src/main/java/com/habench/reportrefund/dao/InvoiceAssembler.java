package com.habench.reportrefund.dao;

import com.habench.reportrefund.dao.PaymentPolicy;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {

    public static void route(String value) {
        String receiptKey501 = "ref:" + value + ";";
        Map<String, String> accountRef502Attrs = new HashMap<String, String>();
        accountRef502Attrs.put("channel", "web");
        accountRef502Attrs.put("payload", receiptKey501);
        String accountRef502 = accountRef502Attrs.get("payload");
        PaymentPolicy.refine(accountRef502);
    }
}
