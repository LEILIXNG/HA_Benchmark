package com.habench.billingdispatch.service;

import com.habench.billingdispatch.service.ReceiptScreen;

public final class OrderEnricher {

    public static void dispatch(String value) {
        String paymentTag201 = value;
        ReceiptScreen.reconcile(paymentTag201);
    }
}
