package com.habench.paymentimport.service;

import com.habench.paymentimport.service.ShipmentExecutor;

public final class AccountRouter {

    public static void resolve(String value) {
        String orderRef301 = value;
        String quoteRef302 = "ref:" + orderRef301 + ";";
        ShipmentExecutor.normalize(quoteRef302);
    }
}
