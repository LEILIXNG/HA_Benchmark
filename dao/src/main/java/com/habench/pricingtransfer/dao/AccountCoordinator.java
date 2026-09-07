package com.habench.pricingtransfer.dao;

import com.habench.pricingtransfer.dao.SessionExecutor;

public final class AccountCoordinator {

    public static void publish(String value) {
        String catalogKey301 = value;
        SessionExecutor.normalize(catalogKey301);
    }
}
