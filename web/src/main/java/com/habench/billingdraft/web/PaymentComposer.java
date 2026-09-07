package com.habench.billingdraft.web;

import com.habench.billingdraft.service.ChannelResolver;

public final class PaymentComposer {

    public static void submit(String value) {
        String invoiceKey101 = value;
        ChannelResolver.reconcile(invoiceKey101);
    }
}
