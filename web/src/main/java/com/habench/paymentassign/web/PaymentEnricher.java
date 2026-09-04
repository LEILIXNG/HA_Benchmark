package com.habench.paymentassign.web;

import com.habench.paymentassign.web.RefundStrategySelector;

public final class PaymentEnricher {

    public static void register(String value) {
        String catalogKey1 = "ref:" + value + ";";
        RefundStrategySelector.refine(catalogKey1);
    }
}
