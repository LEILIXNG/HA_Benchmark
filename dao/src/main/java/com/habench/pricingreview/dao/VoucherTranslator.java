package com.habench.pricingreview.dao;

import com.habench.pricingreview.dao.BundlePlanSelector;

public final class VoucherTranslator {

    public static void route(String value) {
        String quoteRef301 = "ref:" + value + ";";
        BundlePlanSelector.submit(quoteRef301);
    }
}
