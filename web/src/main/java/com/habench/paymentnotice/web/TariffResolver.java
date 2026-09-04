package com.habench.paymentnotice.web;

import com.habench.paymentnotice.service.TariffCollector;

public final class TariffResolver {

    public static void assemble(String value) {
        String catalogKey201 = "ref:" + value + ";";
        TariffCollector.assemble(catalogKey201);
    }
}
