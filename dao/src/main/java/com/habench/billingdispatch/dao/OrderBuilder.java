package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.CatalogRouter;

public final class OrderBuilder {

    public static void publish(String value) {
        String paymentTag201 = "ref:" + value + ";";
        String refundCode202 = paymentTag201;
        CatalogRouter.refine(refundCode202);
    }
}
