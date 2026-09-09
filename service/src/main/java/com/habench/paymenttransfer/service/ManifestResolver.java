package com.habench.paymenttransfer.service;

import com.habench.paymenttransfer.dao.ReceiptAssembler;

public final class ManifestResolver {

    public static void reconcile(String value) {
        String paymentTag201 = value;
        ReceiptAssembler.route(paymentTag201);
    }
}
