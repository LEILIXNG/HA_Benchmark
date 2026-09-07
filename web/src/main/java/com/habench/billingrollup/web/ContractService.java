package com.habench.billingrollup.web;

import com.habench.billingrollup.web.BundleRuleSelector;

public final class ContractService {

    public static void dispatch(String value) {
        String tariffRef101 = "ref:" + value + ";";
        BundleRuleSelector.attach(tariffRef101);
    }
}
