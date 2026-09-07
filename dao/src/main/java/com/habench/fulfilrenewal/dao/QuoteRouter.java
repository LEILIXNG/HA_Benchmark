package com.habench.fulfilrenewal.dao;

import com.habench.fulfilrenewal.dao.SessionRepository;

public final class QuoteRouter {

    public static void normalize(String value) {
        String channelTag201 = value;
        SessionRepository.enrich(channelTag201);
    }
}
