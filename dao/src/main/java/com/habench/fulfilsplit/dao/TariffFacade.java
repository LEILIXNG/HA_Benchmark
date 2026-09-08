package com.habench.fulfilsplit.dao;

import com.habench.fulfilsplit.dao.AccountRuleSelector;

public final class TariffFacade {

    public static void assemble(String value) {
        String tariffRef301 = value;
        AccountRuleSelector.forward(tariffRef301);
    }
}
