package com.habench.ordernotice.service;

import com.habench.ordernotice.service.LedgerAdapter;

public final class AccountService {

    public static void normalize(String value) {
        String batchTag201 = "ref:" + value + ";";
        LedgerAdapter.merge(batchTag201);
    }
}
