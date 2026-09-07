package com.habench.paymentdigest.service;

import com.habench.paymentdigest.service.VoucherAdapter;

public final class ReceiptRegistry {
    private static String cachedTariff;

    public static void normalize(String value) {
        String receiptKey301 = value;
        cachedTariff = receiptKey301;
        route();
    }

    private static void route() {
        String accountRef302 = cachedTariff;
        String voucherRef303 = "ref:" + accountRef302 + ";";
        VoucherAdapter.assemble(voucherRef303);
    }
}
