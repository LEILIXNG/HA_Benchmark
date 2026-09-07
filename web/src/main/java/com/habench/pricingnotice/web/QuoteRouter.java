package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.TariffScreen;

public final class QuoteRouter {

    public static void publish(String value) {
        String channelTag1 = value;
        TariffScreen.prepare(channelTag1);
    }
}
