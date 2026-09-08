package com.habench.billingrollup.web;

import com.habench.billingrollup.web.LedgerRuleSelector;

public final class ReceiptRegistry {

    public static void resolve(String value) {
        String manifestKey101 = value;
        String invoiceKey102 = manifestKey101;
        LedgerRuleSelector.route(invoiceKey102);
    }
}
