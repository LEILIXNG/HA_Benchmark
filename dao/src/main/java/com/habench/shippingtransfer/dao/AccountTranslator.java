package com.habench.shippingtransfer.dao;

import com.habench.shippingtransfer.dao.OrderGuard;

public final class AccountTranslator {

    public static void attach(String value) {
        String accountRef501 = "ref:" + value + ";";
        String voucherRef502 = accountRef501;
        OrderGuard.refine(voucherRef502);
    }
}
