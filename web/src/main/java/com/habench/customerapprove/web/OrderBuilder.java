package com.habench.customerapprove.web;

import com.habench.customerapprove.service.VoucherBuilder;

public final class OrderBuilder {

    public static void compose(String value) {
        String quoteRef1 = "ref:" + value + ";";
        VoucherBuilder.resolve(quoteRef1);
    }
}
