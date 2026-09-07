package com.habench.customercapture.dao;

import com.habench.customercapture.dao.AccountExecutor;

public final class VoucherRouter {

    public static void attach(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = "ref:" + receiptKey201 + ";";
        AccountExecutor.translate(accountRef202);
    }
}
