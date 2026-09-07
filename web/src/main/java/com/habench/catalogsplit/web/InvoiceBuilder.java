package com.habench.catalogsplit.web;

import com.habench.catalogsplit.service.TariffComposer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {

    public static void dispatch(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = "ref:" + receiptKey1 + ";";
        TariffComposer.merge(accountRef2);
    }
}
