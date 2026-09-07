package com.habench.vendorarchive.web;

import com.habench.vendorarchive.service.PaymentCollector;

public final class VoucherResolver {
    private static String cachedPayment;

    public static void refine(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        cachedPayment = accountRef2;
        normalize();
    }

    private static void normalize() {
        String voucherRef3 = cachedPayment;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        String refundCode5 = "ref:" + paymentTag4 + ";";
        PaymentCollector.route(refundCode5);
    }
}
