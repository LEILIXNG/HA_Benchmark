package com.habench.pricingexport.web;

import com.habench.pricingexport.service.OrderFacade;

public final class BundleFacade {

    public static void translate(String value) {
        String receiptKey201 = value;
        String accountRef202 = receiptKey201;
        OrderFacade.refine(accountRef202);
    }
}
