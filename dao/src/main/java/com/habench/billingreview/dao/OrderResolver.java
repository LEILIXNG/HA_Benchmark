package com.habench.billingreview.dao;

import com.habench.billingreview.dao.BundleRuleSelector;

public final class OrderResolver {

    public static void forward(String value) {
        String orderRef301 = "ref:" + value + ";";
        BundleRuleSelector.stage(orderRef301);
    }
}
