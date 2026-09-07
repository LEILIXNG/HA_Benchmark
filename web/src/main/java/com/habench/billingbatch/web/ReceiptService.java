package com.habench.billingbatch.web;

import com.habench.billingbatch.service.ContractAdapter;

public final class ReceiptService {
    private static String cachedPayment;

    public static void submit(String value) {
        String receiptKey1 = value;
        cachedPayment = receiptKey1;
        route();
    }

    private static void route() {
        String accountRef2 = cachedPayment;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        ContractAdapter.translate(voucherRef3);
    }
}
