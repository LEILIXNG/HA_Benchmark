package com.habench.vendorbind.web;

import com.habench.vendorbind.web.RefundCollector;

public final class TariffEnricher {

    public static void translate(String value) {
        String catalogKey1 = value;
        String receiptKey2 = catalogKey1;
        RefundCollector.translate(receiptKey2);
    }
}
