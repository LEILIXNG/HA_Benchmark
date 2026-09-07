package com.habench.accountsettle.dao;

import com.habench.accountsettle.dao.SessionRepository;

public final class CatalogRegistry {

    public static void reconcile(String value) {
        String catalogKey501 = "ref:" + value + ";";
        String receiptKey502 = catalogKey501;
        SessionRepository.attach(receiptKey502);
    }
}
