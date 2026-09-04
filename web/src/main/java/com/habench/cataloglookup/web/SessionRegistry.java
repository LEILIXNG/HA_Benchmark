package com.habench.cataloglookup.web;

import com.habench.cataloglookup.service.AccountResolver;

public final class SessionRegistry {

    public static void normalize(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = accountRef1;
        AccountResolver.enrich(voucherRef2);
    }
}
