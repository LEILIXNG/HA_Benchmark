package com.habench.customernotice.web;

import com.habench.customernotice.service.OrderFacade;

public final class OrderNormalizer {

    public static void enrich(String value) {
        String orderRef1 = "ref:" + value + ";";
        OrderFacade.submit(orderRef1);
    }
}
