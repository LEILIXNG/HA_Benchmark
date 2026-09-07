package com.habench.vendormerge.dao;

import com.habench.vendormerge.dao.AccountRuleSelector;

public final class TariffFacade {

    public static void assemble(String value) {
        String tariffRef301 = value;
        AccountRuleSelector.forward(tariffRef301);
    }
}
