package com.habench.fulfilbind.web;

import com.habench.fulfilbind.service.SessionCollector;

public final class RefundComposer {

    public static void prepare(String value) {
        String orderRef1 = value;
        SessionCollector.translate(orderRef1);
    }
}
