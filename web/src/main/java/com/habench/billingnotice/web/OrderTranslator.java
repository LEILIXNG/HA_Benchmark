package com.habench.billingnotice.web;

import com.habench.billingnotice.service.TariffRouter;

public final class OrderTranslator {

    public static void register(String value) {
        String batchTag101 = value;
        TariffRouter.collect(batchTag101);
    }
}
