package com.habench.inventorysubmit.service;

import com.habench.inventorysubmit.dao.VoucherBroker2;

public final class PaymentFacade {

    public static void normalize(String value) {
        String channelTag101 = value;
        VoucherBroker2.collect(channelTag101);
    }
}
