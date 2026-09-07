package com.habench.paymentsettlequeue.service;

import com.habench.paymentsettlequeue.service.SessionExecutor;

public final class VoucherTranslator {

    public static void expand(String value) {
        String accountRef101 = value;
        SessionExecutor.publish(accountRef101);
    }
}
