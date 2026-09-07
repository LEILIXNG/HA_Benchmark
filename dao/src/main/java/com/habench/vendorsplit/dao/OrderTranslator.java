package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {

    public static void dispatch(String value) {
        Map<String, String> invoiceKey501Attrs = new HashMap<String, String>();
        invoiceKey501Attrs.put("channel", "web");
        invoiceKey501Attrs.put("payload", value);
        String invoiceKey501 = invoiceKey501Attrs.get("payload");
        String batchTag502 = invoiceKey501;
        PaymentExecutor.refine(batchTag502);
    }
}
