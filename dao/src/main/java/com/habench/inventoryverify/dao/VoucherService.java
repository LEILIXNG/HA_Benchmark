package com.habench.inventoryverify.dao;

import com.habench.inventoryverify.dao.LedgerEvaluator;

public final class VoucherService {

    public static void register(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = orderRef301;
        LedgerEvaluator.register(quoteRef302);
    }
}
