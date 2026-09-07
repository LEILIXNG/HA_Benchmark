package com.habench.inventorycapture.service;

import com.habench.inventorycapture.service.RefundBuilder;

public final class CatalogService {

    public static void assemble(String value) {
        String accountRef101 = "ref:" + value + ";";
        String voucherRef102 = "ref:" + accountRef101 + ";";
        RefundBuilder.publish(voucherRef102);
    }
}
