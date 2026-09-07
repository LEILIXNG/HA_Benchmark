package com.habench.shippingverify.web;

import com.habench.shippingverify.service.VoucherBuilder;

public final class OrderBuilder {

    public static void compose(String value) {
        String quoteRef1 = "ref:" + value + ";";
        VoucherBuilder.resolve(quoteRef1);
    }
}
