package com.habench.fulfilreview.dao;

import com.habench.fulfilreview.dao.BundlePlanSelector;

public final class VoucherTranslator {

    public static void route(String value) {
        String quoteRef301 = "ref:" + value + ";";
        BundlePlanSelector.submit(quoteRef301);
    }
}
