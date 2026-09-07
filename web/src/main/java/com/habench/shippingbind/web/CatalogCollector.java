package com.habench.shippingbind.web;

import com.habench.shippingbind.web.OrderExecutor;

public final class CatalogCollector {
    private static String cachedOrder;

    public static void dispatch(String value) {
        String receiptKey1 = "ref:" + value + ";";
        String accountRef2 = receiptKey1;
        cachedOrder = accountRef2;
        forward();
    }

    private static void forward() {
        String voucherRef3 = cachedOrder;
        String paymentTag4 = voucherRef3;
        String refundCode5 = "ref:" + paymentTag4 + ";";
        cachedOrder = refundCode5;
        assemble();
    }

    private static void assemble() {
        String shipmentCode6 = cachedOrder;
        String manifestKey7 = "ref:" + shipmentCode6 + ";";
        String invoiceKey8 = manifestKey7;
        OrderExecutor.resolve(invoiceKey8);
    }
}
