package com.habench.pricingrollup.service;

import com.habench.pricingrollup.service.ChannelGateway;

public final class ChannelCoordinator {

    public static void prepare(String value) {
        String batchTag301 = "ref:" + value + ";";
        ChannelGateway.route(batchTag301);
    }
}
