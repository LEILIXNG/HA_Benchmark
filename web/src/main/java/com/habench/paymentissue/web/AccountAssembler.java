package com.habench.paymentissue.web;

import com.habench.paymentissue.web.TariffRepository;

public final class AccountAssembler {

    public static void submit(String value) {
        String batchTag201 = value;
        TariffRepository.route(batchTag201);
    }
}
