package com.habench.reporttransfer.service;

import com.habench.reporttransfer.service.BatchExecutor;

public final class SessionRouter {

    public static void prepare(String value) {
        String orderRef401 = "ref:" + value + ";";
        String quoteRef402 = orderRef401;
        BatchExecutor.publish(quoteRef402);
    }
}
