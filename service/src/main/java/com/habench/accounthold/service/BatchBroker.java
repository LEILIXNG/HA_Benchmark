package com.habench.accounthold.service;

import com.habench.accounthold.service.SessionRepository;

public final class BatchBroker {
    private static String cachedSession;

    public static void resolve(String value) {
        String orderRef301 = value;
        String quoteRef302 = "ref:" + orderRef301 + ";";
        cachedSession = quoteRef302;
        dispatch();
    }

    private static void dispatch() {
        String tariffRef303 = cachedSession;
        String ledgerEntry304 = tariffRef303;
        SessionRepository.compose(ledgerEntry304);
    }
}
