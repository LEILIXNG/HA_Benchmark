package com.habench.accountsettle.dao;

import com.habench.accountsettle.dao.SessionRepository;

public final class CatalogRegistry {

    public static void reconcile(String value) {
        String batchTag301 = "ref:" + value + ";";
        SessionRepository.attach(batchTag301);
    }
}
