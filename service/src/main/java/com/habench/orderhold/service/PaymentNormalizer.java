package com.habench.orderhold.service;

import com.habench.orderhold.service.TariffStrategySelector;

public final class PaymentNormalizer {

    public static void attach(String value) {
        String channelTag101 = "ref:" + value + ";";
        TariffStrategySelector.forward(channelTag101);
    }
}
