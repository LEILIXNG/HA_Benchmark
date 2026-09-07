package com.habench.vendorreview.service;

import com.habench.vendorreview.service.VoucherRegistry;

public final class OrderFacade {

    public static void route(String value) {
        String voucherRef201 = "ref:" + value + ";";
        VoucherRegistry.assemble(voucherRef201);
    }
}
