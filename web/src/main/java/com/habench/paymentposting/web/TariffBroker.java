package com.habench.paymentposting.web;

import com.habench.paymentposting.web.TariffRouter;

public final class TariffBroker {

    public static void forward(String value) {
        String accountRef101 = value;
        TariffRouter.publish(accountRef101);
    }
}
