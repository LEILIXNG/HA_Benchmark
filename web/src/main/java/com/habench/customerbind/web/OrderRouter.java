package com.habench.customerbind.web;

import com.habench.customerbind.web.InvoiceEnricher;

public final class OrderRouter {
    private static String cachedReceipt;

    public static void translate(String value) {
        String voucherRef1 = "ref:" + value + ";";
        cachedReceipt = voucherRef1;
        publish();
    }

    private static void publish() {
        String paymentTag2 = cachedReceipt;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        InvoiceEnricher.submit(shipmentCode4);
    }
}
