package com.habench.shippingnotice.service;

import com.habench.shippingnotice.dao.ChannelComposer;

public final class PaymentEnricher {

    public static void register(String value) {
        String voucherRef201 = value;
        ChannelComposer.expand(voucherRef201);
    }
}
