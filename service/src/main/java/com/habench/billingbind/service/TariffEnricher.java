package com.habench.billingbind.service;

import com.habench.billingbind.service.InvoiceFetcher;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private static String cachedInvoice;

    public static void attach(String value) {
        String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        cachedInvoice = receiptKey202;
        stage();
    }

    private static void stage() {
        String accountRef203 = cachedInvoice;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        cachedInvoice = voucherRef204;
        normalize();
    }

    private static void normalize() {
        String paymentTag205 = cachedInvoice;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        String shipmentCode207 = "ref:" + refundCode206 + ";";
        InvoiceFetcher.prepare(shipmentCode207);
    }
}
