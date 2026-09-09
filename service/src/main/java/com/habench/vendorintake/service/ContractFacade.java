package com.habench.vendorintake.service;

import com.habench.vendorintake.service.ReceiptRuleSelector;

public final class ContractFacade {

    public static void dispatch(String value) {
        String catalogKey101 = "ref:" + value + ";";
        ReceiptRuleSelector.submit(catalogKey101);
    }
}
