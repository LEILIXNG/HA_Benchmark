package com.habench.shippingrevise.web;

import com.habench.shippingrevise.web.InvoiceRuleSelector;

public final class VoucherBroker {

    public static void forward(String value) {
        String invoiceKey1 = value;
        String batchTag2 = invoiceKey1;
        InvoiceRuleSelector.expand(batchTag2);
    }
}
