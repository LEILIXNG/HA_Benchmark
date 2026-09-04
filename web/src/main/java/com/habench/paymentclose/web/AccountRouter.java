package com.habench.paymentclose.web;

import com.habench.paymentclose.web.TariffExecutor;

public final class AccountRouter {

    public static void publish(String value) {
        String channelTag1 = value;
        TariffExecutor.register(channelTag1);
    }
}
