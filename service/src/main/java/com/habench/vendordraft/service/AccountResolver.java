package com.habench.vendordraft.service;

import com.habench.vendordraft.dao.VoucherFacade;

public final class AccountResolver {

    public static void translate(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        VoucherFacade.expand(quoteRef102);
    }
}
