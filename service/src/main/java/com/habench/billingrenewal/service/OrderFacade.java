package com.habench.billingrenewal.service;

import com.habench.billingrenewal.dao.PaymentAssembler;

public final class OrderFacade {

    public static void prepare(String value) {
        PaymentAssembler.collect(value);
    }
}
