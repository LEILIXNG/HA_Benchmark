package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.AccountService;

public final class LedgerCoordinator {

    public static void publish(String value) {
        String voucherRef401 = "ref:" + value + ";";
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        AccountService.stage(paymentTag402);
    }
}
