package com.habench.vendorreview.web;

import com.habench.vendorreview.web.QuoteGuard;

public final class PaymentTranslator {
    private static String cachedOrder;

    public static void compose(String value) {
        String channelTag101 = value;
        String catalogKey102 = channelTag101;
        cachedOrder = catalogKey102;
        assemble();
    }

    private static void assemble() {
        String receiptKey103 = cachedOrder;
        String accountRef104 = "ref:" + receiptKey103 + ";";
        QuoteGuard.reconcile(accountRef104);
    }
}
