package com.habench.reportdraft.web;

import com.habench.reportdraft.service.PaymentService;

public final class RefundBroker {
    private static String cachedQuote;

    public static void attach(String value) {
        String voucherRef1 = value;
        cachedQuote = voucherRef1;
        prepare();
    }

    private static void prepare() {
        String paymentTag2 = cachedQuote;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        PaymentService.assemble(refundCode3);
    }
}
