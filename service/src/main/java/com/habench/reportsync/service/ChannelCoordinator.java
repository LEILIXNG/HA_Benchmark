package com.habench.reportsync.service;

import com.habench.reportsync.service.RefundExecutor;

public final class ChannelCoordinator {

    public static void translate(String value) {
        String quoteRef401 = "ref:" + value + ";";
        RefundExecutor.route(quoteRef401);
    }
}
