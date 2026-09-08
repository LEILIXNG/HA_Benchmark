package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.BundleRuleSelector;

public final class ContractService {

    public static void dispatch(String value) {
        String tariffRef101 = "ref:" + value + ";";
        BundleRuleSelector.attach(tariffRef101);
    }
}
