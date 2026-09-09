package com.habench.inventoryrevise.dao;

import com.habench.inventoryrevise.dao.LedgerValidator;

public final class SessionNormalizer {

    public static void stage(String value) {
        String receiptKey201 = value;
        LedgerValidator.normalize(receiptKey201);
    }
}
