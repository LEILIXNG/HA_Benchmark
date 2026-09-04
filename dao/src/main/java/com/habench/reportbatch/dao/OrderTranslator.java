package com.habench.reportbatch.dao;

import com.habench.reportbatch.dao.LedgerPlanSelector;

public final class OrderTranslator {
    private static String cachedBundle;

    public static void forward(String value) {
        String accountRef301 = "ref:" + value + ";";
        cachedBundle = accountRef301;
        route();
    }

    private static void route() {
        String voucherRef302 = cachedBundle;
        String paymentTag303 = "ref:" + voucherRef302 + ";";
        String refundCode304 = paymentTag303;
        LedgerPlanSelector.route(refundCode304);
    }
}
