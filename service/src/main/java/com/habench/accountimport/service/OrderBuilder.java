package com.habench.accountimport.service;

import com.habench.accountimport.service.ContractExecutor;

public final class OrderBuilder {

    public static void route(String value) {
        String receiptKey401 = value;
        String accountRef402 = "ref:" + receiptKey401 + ";";
        ContractExecutor.compose(accountRef402);
    }
}
