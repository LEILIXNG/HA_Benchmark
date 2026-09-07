package com.habench.billinghold.web;

import com.habench.billinghold.service.ContractTranslator;

public final class ReceiptRouter {

    public static void submit(String value) {
        String accountRef101 = "ref:" + value + ";";
        ContractTranslator.normalize(accountRef101);
    }
}
