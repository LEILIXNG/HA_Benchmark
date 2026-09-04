package com.habench.fulfilreconcile.service;

import com.habench.fulfilreconcile.dao.PaymentService;

public final class TariffBuilder {

    public static void expand(String value) {
        PaymentService.merge(value);
    }
}
