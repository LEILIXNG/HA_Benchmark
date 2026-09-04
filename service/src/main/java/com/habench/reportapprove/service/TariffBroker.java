package com.habench.reportapprove.service;

import com.habench.reportapprove.service.BatchStrategySelector;

public final class TariffBroker {

    public static void submit(String value) {
        String channelTag501 = value;
        BatchStrategySelector.dispatch(channelTag501);
    }
}
