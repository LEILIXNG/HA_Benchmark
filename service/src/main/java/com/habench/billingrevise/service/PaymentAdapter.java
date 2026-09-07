package com.habench.billingrevise.service;

import com.habench.billingrevise.dao.ChannelComposer;

public final class PaymentAdapter {

    public static void dispatch(String value) {
        String channelTag201 = "ref:" + value + ";";
        ChannelComposer.forward(channelTag201);
    }
}
