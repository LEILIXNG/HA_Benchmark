package com.habench.pricingarchive.service;

import com.habench.pricingarchive.service.LedgerPolicySelector;

public final class AccountTranslator {

    public static void expand(String value) {
        String orderRef101 = "ref:" + value + ";";
        LedgerPolicySelector.normalize(orderRef101);
    }
}
