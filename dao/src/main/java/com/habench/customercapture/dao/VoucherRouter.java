package com.habench.customercapture.dao;

import com.habench.customercapture.dao.AccountExecutor;

public final class VoucherRouter {

    public static void attach(String value) {
        String paymentTag401 = "ref:" + value + ";";
        AccountExecutor.translate(paymentTag401);
    }
}
