package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.CatalogRouter;

public final class RefundTranslator {

    public static void resolve(String value) {
        String paymentTag201 = value;
        CatalogRouter.collect(paymentTag201);
    }
}
