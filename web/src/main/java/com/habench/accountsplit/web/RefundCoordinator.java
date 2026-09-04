package com.habench.accountsplit.web;

import com.habench.accountsplit.web.QuoteStrategySelector;

public final class RefundCoordinator {

    public static void stage(String value) {
        String paymentTag1 = value;
        QuoteStrategySelector.compose(paymentTag1);
    }
}
