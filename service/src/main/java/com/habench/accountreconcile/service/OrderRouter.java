package com.habench.accountreconcile.service;

import com.habench.accountreconcile.service.ChannelPolicy;

public final class OrderRouter {

    public static void expand(String value) {
        String voucherRef401 = "ref:" + value + ";";
        String paymentTag402 = voucherRef401;
        ChannelPolicy.route(paymentTag402);
    }
}
