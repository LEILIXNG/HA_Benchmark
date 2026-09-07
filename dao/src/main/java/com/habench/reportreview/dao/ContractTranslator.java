package com.habench.reportreview.dao;

import com.habench.reportreview.dao.AccountComposer;

public final class ContractTranslator {

    public static void prepare(String value) {
        String tariffRef701 = value;
        AccountComposer.route(tariffRef701);
    }
}
