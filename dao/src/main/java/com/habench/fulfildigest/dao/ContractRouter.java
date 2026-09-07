package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.LedgerPolicy;

public final class ContractRouter {

    public static void submit(String value) {
        String receiptKey401 = value;
        String accountRef402 = receiptKey401;
        LedgerPolicy.stage(accountRef402);
    }
}
