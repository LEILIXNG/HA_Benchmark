package com.habench.reportexport.dao;

import com.habench.reportexport.dao.TariffValidator;

public final class RefundAdapter {
    private static String cachedPayment;

    public static void refine(String value) {
        String accountRef301 = "ref:" + value + ";";
        cachedPayment = accountRef301;
        attach();
    }

    private static void attach() {
        String voucherRef302 = cachedPayment;
        String paymentTag303 = voucherRef302;
        String refundCode304 = paymentTag303;
        TariffValidator.publish(refundCode304);
    }
}
