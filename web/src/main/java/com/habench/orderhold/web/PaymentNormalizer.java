package com.habench.orderhold.web;

import com.habench.orderhold.service.TariffRouter;

public final class PaymentNormalizer {

    public static void attach(String value) {
        String channelTag1 = "ref:" + value + ";";
        TariffRouter.enrich(channelTag1);
    }
}
