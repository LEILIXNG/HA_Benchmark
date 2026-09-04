package com.habench.shippingsettle.service;

import com.habench.shippingsettle.dao.ContractGuard;

public final class LedgerRegistry {

    public static void attach(String value) {
        String receiptKey101 = value;
        String accountRef102 = "ref:" + receiptKey101 + ";";
        ContractGuard.translate(accountRef102);
    }
}
