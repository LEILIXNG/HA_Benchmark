package com.habench.customerposting.web;

import com.habench.customerposting.web.TariffTranslator;

public final class ContractAssembler {
    private static String cachedQuote;

    public static void enrich(String value) {
        String receiptKey1 = value;
        cachedQuote = receiptKey1;
        stage();
    }

    private static void stage() {
        String accountRef2 = cachedQuote;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        String paymentTag4 = voucherRef3;
        TariffTranslator.resolve(paymentTag4);
    }
}
