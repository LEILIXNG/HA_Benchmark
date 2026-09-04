package com.habench.shippingmerge.dao;

import com.habench.shippingmerge.dao.BundlePolicySelector;

public final class QuoteTranslator {

    public static void dispatch(String value) {
        String receiptKey301 = value;
        BundlePolicySelector.assemble(receiptKey301);
    }
}
