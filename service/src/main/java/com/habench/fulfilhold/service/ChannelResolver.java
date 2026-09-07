package com.habench.fulfilhold.service;

import com.habench.fulfilhold.dao.RefundRegistry;

public final class ChannelResolver {

    public static void submit(String value) {
        String orderRef101 = value;
        RefundRegistry.stage(orderRef101);
    }
}
