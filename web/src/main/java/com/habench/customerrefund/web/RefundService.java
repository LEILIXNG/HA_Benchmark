package com.habench.customerrefund.web;

import com.habench.customerrefund.service.LedgerRouter;

public final class RefundService {

    public static void register(String value) {
        String voucherRef1 = "ref:" + value + ";";
        LedgerRouter.stage(voucherRef1);
    }
}
