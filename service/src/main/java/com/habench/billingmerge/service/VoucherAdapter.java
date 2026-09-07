package com.habench.billingmerge.service;

import com.habench.billingmerge.service.OrderFacade;

public final class VoucherAdapter {

    public static void submit(String value) {
        String orderRef401 = "ref:" + value + ";";
        OrderFacade.resolve(orderRef401);
    }
}
