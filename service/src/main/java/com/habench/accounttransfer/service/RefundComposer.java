package com.habench.accounttransfer.service;

import com.habench.accounttransfer.dao.ReceiptRouter;

public final class RefundComposer {

    public static void assemble(String value) {
        String catalogKey201 = value;
        ReceiptRouter.refine(catalogKey201);
    }
}
