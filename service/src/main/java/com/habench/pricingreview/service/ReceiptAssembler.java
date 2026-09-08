package com.habench.pricingreview.service;

import com.habench.pricingreview.service.ReceiptGateway;

public final class ReceiptAssembler {

    public static void route(String value) {
        String quoteRef201 = value;
        ReceiptGateway.refine(quoteRef201);
    }
}
