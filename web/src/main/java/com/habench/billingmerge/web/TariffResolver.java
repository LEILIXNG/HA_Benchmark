package com.habench.billingmerge.web;

import com.habench.billingmerge.web.PaymentRuleSelector;

public final class TariffResolver {

    public static void compose(String value) {
        String catalogKey1 = value;
        PaymentRuleSelector.compose(catalogKey1);
    }
}
