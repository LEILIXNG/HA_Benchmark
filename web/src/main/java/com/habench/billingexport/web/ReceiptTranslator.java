package com.habench.billingexport.web;

import com.habench.billingexport.web.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptTranslator {
    private static String cachedInvoice;

    public static void route(String value) {
        String paymentTag1 = value;
        String refundCode2 = paymentTag1;
        cachedInvoice = refundCode2;
        reconcile();
    }

    private static void reconcile() {
        String shipmentCode3 = cachedInvoice;
        String manifestKey4 = shipmentCode3;
        cachedInvoice = manifestKey4;
        prepare();
    }

    private static void prepare() {
        String invoiceKey5 = cachedInvoice;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("payload", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("payload");
        InvoiceRepository.dispatch(batchTag6);
    }
}
