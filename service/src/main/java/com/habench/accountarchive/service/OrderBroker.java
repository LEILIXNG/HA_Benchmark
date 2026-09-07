package com.habench.accountarchive.service;

import com.habench.accountarchive.dao.ContractTranslator;

public final class OrderBroker {

    public static void assemble(String value) {
        String manifestKey201 = "ref:" + value + ";";
        ContractTranslator.collect(manifestKey201);
    }
}
