package com.habench.billingnotice.dao;

import com.habench.billingnotice.dao.ChannelValidator;

public final class RefundComposer {

    public static void register(String value) {
        String channelTag301 = "ref:" + value + ";";
        ChannelValidator.compose(channelTag301);
    }
}
