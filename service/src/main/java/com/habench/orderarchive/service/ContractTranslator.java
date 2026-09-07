package com.habench.orderarchive.service;

import com.habench.orderarchive.service.AccountPolicySelector;

public final class ContractTranslator {

    public static void assemble(String value) {
        String accountRef101 = "ref:" + value + ";";
        AccountPolicySelector.attach(accountRef101);
    }
}
