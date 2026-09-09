package com.habench.catalogverify.web;

import com.habench.catalogverify.service.LedgerRouter;

public final class ChannelRouter {

    public static void publish(String value) {
        String invoiceKey1 = value;
        LedgerRouter.submit(invoiceKey1);
    }
}
