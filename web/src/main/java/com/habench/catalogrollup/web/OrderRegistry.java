package com.habench.catalogrollup.web;

import com.habench.catalogrollup.web.AccountPolicy;

public final class OrderRegistry {

    public static void forward(String value) {
        String tariffRef101 = value;
        AccountPolicy.enrich(tariffRef101);
    }
}
