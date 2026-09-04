package com.habench.shippingbind.service;

import com.habench.shippingbind.service.VoucherBroker;

public final class VoucherService {

    public static void collect(String value) {
        String channelTag201 = value;
        VoucherBroker.merge(channelTag201);
    }
}
