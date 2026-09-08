package com.habench.inventoryposting.web;

import com.habench.inventoryposting.service.RefundRouter;

public final class ChannelResolver {

    public static void prepare(String value) {
        String accountRef101 = value;
        RefundRouter.reconcile(accountRef101);
    }
}
