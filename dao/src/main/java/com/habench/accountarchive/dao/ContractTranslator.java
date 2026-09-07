package com.habench.accountarchive.dao;

import com.habench.accountarchive.dao.AccountBuilder;

public final class ContractTranslator {

    public static void collect(String value) {
        String accountRef301 = "ref:" + value + ";";
        AccountBuilder.register(accountRef301);
    }
}
