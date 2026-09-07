package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.InvoiceRuleSelector;

public final class PaymentResolver {

    public static void enrich(String value) {
        String refundCode101 = "ref:" + value + ";";
        InvoiceRuleSelector.submit(refundCode101);
    }
}
