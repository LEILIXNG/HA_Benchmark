package com.habench.accounttrace.web;

import com.habench.accounttrace.service.BundleTranslator;

public final class QuoteCoordinator {

    public static void reconcile(String value) {
        String receiptKey101 = "ref:" + value + ";";
        BundleTranslator.translate(receiptKey101);
    }
}
