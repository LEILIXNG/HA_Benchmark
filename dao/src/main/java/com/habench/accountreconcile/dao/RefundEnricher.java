package com.habench.accountreconcile.dao;

import com.habench.accountreconcile.dao.BatchRouter;

public final class RefundEnricher {

    public static void attach(String value) {
        String tariffRef401 = value;
        BatchRouter.reconcile(tariffRef401);
    }
}
