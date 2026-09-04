package com.habench.orderrefund.web;

import com.habench.orderrefund.web.BundleRuleSelector;

public final class SessionRegistry {

    public static void assemble(String value) {
        String manifestKey1 = "ref:" + value + ";";
        BundleRuleSelector.resolve(manifestKey1);
    }
}
