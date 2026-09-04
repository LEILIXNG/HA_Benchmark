package com.habench.customerhold.web;

import com.habench.customerhold.service.ChannelBuilder;

public final class SessionRouter {

    public static void merge(String value) {
        String quoteRef201 = value;
        ChannelBuilder.forward(quoteRef201);
    }
}
