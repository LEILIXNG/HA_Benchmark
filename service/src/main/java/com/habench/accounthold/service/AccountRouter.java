package com.habench.accounthold.service;

import com.habench.accounthold.service.BatchBroker;

public final class AccountRouter {

    public static void prepare(String value) {
        String catalogKey201 = "ref:" + value + ";";
        BatchBroker.resolve(catalogKey201);
    }
}
