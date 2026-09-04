package com.habench.billingarchive.service;

import com.habench.billingarchive.service.AccountComposer;

public final class SessionService {

    public static void register(String value) {
        AccountComposer.merge(value);
    }
}
