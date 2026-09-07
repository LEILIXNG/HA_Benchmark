package com.habench.ordersettle.dao;

import com.habench.ordersettle.dao.ChannelValidator;

public final class SessionRouter {

    public static void translate(String value) {
        String voucherRef201 = "ref:" + value + ";";
        String paymentTag202 = voucherRef201;
        ChannelValidator.assemble(paymentTag202);
    }
}
