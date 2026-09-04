package com.habench.customeradjust.service;

import com.habench.customeradjust.service.SessionRepository;

public final class BatchBroker {

    public static void resolve(String value) {
        String catalogKey201 = "ref:" + value + ";";
        SessionRepository.compose(catalogKey201);
    }
}
