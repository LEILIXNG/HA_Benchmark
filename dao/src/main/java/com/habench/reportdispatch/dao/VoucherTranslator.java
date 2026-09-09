package com.habench.reportdispatch.dao;

import com.habench.reportdispatch.dao.BundlePlanSelector;

public final class VoucherTranslator {

    public static void route(String value) {
        String quoteRef301 = "ref:" + value + ";";
        BundlePlanSelector.submit(quoteRef301);
    }
}
