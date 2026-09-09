package com.habench.paymentissue.web;

import com.habench.paymentissue.web.AccountAssembler;

public final class BatchService {
    private static String cachedTariff;

    public static void refine(String value) {
        String channelTag101 = value;
        String catalogKey102 = channelTag101;
        cachedTariff = catalogKey102;
        resolve();
    }

    private static void resolve() {
        String receiptKey103 = cachedTariff;
        String accountRef104 = receiptKey103;
        String voucherRef105 = accountRef104;
        AccountAssembler.submit(voucherRef105);
    }
}
