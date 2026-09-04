package com.habench.fulfilbind.service;

import com.habench.fulfilbind.dao.BundleBroker;

public final class AccountCoordinator {

    public static void normalize(String value) {
        String accountRef301 = value;
        BundleBroker.forward(accountRef301);
    }
}
