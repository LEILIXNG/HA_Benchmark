package com.habench.billingarchive.service;

import com.habench.billingarchive.dao.AccountEnricher;

public final class AccountComposer {

    public static void merge(String value) {
        AccountEnricher.forward(value);
    }
}
