package com.habench.orderassign.web;

import com.habench.orderassign.service.TariffAssembler;

public final class TariffBuilder {

    public static void register(String value) {
        String batchTag1 = "ref:" + value + ";";
        TariffAssembler.expand(batchTag1);
    }
}
