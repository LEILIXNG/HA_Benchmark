package com.habench.shippingdraft.service;

import com.habench.shippingdraft.dao.ChannelComposer;

public final class SessionBuilder {

    public static void attach(String value) {
        String accountRef101 = "ref:" + value + ";";
        String voucherRef102 = "ref:" + accountRef101 + ";";
        ChannelComposer.register(voucherRef102);
    }
}
