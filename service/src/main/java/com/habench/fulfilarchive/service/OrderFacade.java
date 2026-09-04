package com.habench.fulfilarchive.service;

import com.habench.fulfilarchive.dao.PaymentAssembler;

public final class OrderFacade {

    public static void prepare(String value) {
        PaymentAssembler.collect(value);
    }
}
