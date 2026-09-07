package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.SessionResolver;

public final class SessionBroker {

    public static void assemble(String value) {
        String paymentTag1 = "ref:" + value + ";";
        SessionResolver.normalize(paymentTag1);
    }
}
