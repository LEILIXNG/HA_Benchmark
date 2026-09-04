package com.habench.accountdraft.web;

import com.habench.accountdraft.service.TariffAssembler;

public final class TariffEnricher {

    public static void prepare(String value) {
        String orderRef1 = value;
        TariffAssembler.normalize(orderRef1);
    }
}
