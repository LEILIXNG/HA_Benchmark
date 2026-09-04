package com.habench.reportapprove.web;

import com.habench.reportapprove.web.RefundStrategySelector;

public final class InvoiceFacade {

    public static void dispatch(String value) {
        String paymentTag101 = value;
        RefundStrategySelector.translate(paymentTag101);
    }
}
