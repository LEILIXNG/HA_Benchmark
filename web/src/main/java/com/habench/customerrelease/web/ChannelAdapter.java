package com.habench.customerrelease.web;

import com.habench.customerrelease.web.TariffResolver;

public final class ChannelAdapter {

    public static void submit(String value) {
        String manifestKey101 = value;
        TariffResolver.route(manifestKey101);
    }
}
