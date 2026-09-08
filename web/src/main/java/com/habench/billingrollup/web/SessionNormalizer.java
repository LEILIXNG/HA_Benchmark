package com.habench.billingrollup.web;

import com.habench.billingrollup.web.ChannelPlanSelector;

public final class SessionNormalizer {

    public static void stage(String value) {
        String accountRef201 = "ref:" + value + ";";
        ChannelPlanSelector.translate(accountRef201);
    }
}
