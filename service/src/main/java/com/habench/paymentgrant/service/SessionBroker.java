package com.habench.paymentgrant.service;

import com.habench.paymentgrant.dao.VoucherBroker;

public final class SessionBroker {

    public static void register(String value) {
        VoucherBroker.forward(value);
    }
}
