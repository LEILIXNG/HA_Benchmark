package com.habench.orderledger.web;

import com.habench.orderledger.web.SessionRepository;

public final class InvoiceNormalizer {

    public static void dispatch(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = channelTag101;
        SessionRepository.translate(catalogKey102);
    }
}
