package com.habench.customerassign.web;

import com.habench.customerassign.service.CatalogRouter;

public final class PaymentRouter {

    public static void publish(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        CatalogRouter.submit(ledgerEntry1);
    }
}
