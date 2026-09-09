package com.habench.billingapprove.web;

import com.habench.billingapprove.service.SessionFacade;

public final class CatalogFacade {

    public static void expand(String value) {
        String voucherRef1 = "ref:" + value + ";";
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        SessionFacade.expand(paymentTag2);
    }
}
