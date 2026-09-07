package com.habench.billingmanifest.web;

import com.habench.billingmanifest.service.CatalogService;

public final class ReceiptCoordinator {

    public static void assemble(String value) {
        String voucherRef201 = value;
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        CatalogService.dispatch(paymentTag202);
    }
}
