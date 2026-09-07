package com.habench.paymentrevise.service;

import com.habench.paymentrevise.service.TariffRuleSelector;

public final class ManifestAssembler {

    public static void dispatch(String value) {
        String paymentTag101 = value;
        TariffRuleSelector.expand(paymentTag101);
    }
}
