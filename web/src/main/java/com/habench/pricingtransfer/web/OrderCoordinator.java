package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.PaymentFacade;

public final class OrderCoordinator {

    public static void refine(String value) {
        String channelTag1 = value;
        PaymentFacade.submit(channelTag1);
    }
}
