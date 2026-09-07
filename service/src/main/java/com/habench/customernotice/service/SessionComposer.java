package com.habench.customernotice.service;

import com.habench.customernotice.dao.AccountNormalizer;

public final class SessionComposer {

    public static void normalize(String value) {
        String quoteRef101 = "ref:" + value + ";";
        AccountNormalizer.normalize(quoteRef101);
    }
}
