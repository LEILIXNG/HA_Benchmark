package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.LedgerResolver;

public final class ReceiptRegistry {
    private static String cachedBatch;

    public static void compose(String value) {
        String receiptKey101 = "ref:" + value + ";";
        String accountRef102 = receiptKey101;
        cachedBatch = accountRef102;
        merge();
    }

    private static void merge() {
        String voucherRef103 = cachedBatch;
        String paymentTag104 = voucherRef103;
        LedgerResolver.normalize(paymentTag104);
    }
}
