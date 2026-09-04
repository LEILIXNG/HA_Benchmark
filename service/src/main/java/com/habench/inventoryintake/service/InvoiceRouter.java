package com.habench.inventoryintake.service;

import com.habench.inventoryintake.service.ChannelRuleSelector;

public final class InvoiceRouter {

    public static void register(String value) {
        String paymentTag401 = value;
        ChannelRuleSelector.refine(paymentTag401);
    }
}
