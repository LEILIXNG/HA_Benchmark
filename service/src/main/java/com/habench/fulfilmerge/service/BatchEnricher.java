package com.habench.fulfilmerge.service;

import com.habench.fulfilmerge.service.InvoiceGateway;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private static String cachedInvoice;

    public static void submit(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        cachedInvoice = accountRef202;
        prepare();
    }

    private static void prepare() {
        String voucherRef203 = cachedInvoice;
        Map<String, String> paymentTag204Attrs = new HashMap<String, String>();
        paymentTag204Attrs.put("channel", "web");
        paymentTag204Attrs.put("payload", voucherRef203);
        String paymentTag204 = paymentTag204Attrs.get("payload");
        String refundCode205 = paymentTag204;
        InvoiceGateway.reconcile(refundCode205);
    }
}
