package com.habench.reportsync.service;

import com.habench.reportsync.service.RefundExecutor;

public final class ChannelCoordinator {

    public static void translate(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = "ref:" + channelTag201 + ";";
        RefundExecutor.route(catalogKey202);
    }
}
