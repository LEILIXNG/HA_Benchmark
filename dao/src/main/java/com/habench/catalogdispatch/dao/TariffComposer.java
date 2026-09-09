package com.habench.catalogdispatch.dao;

import com.habench.catalogdispatch.dao.ContractPlanSelector;

public final class TariffComposer {

    public static void dispatch(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        ContractPlanSelector.assemble(ledgerEntry301);
    }
}
