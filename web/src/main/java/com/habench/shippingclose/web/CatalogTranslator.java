package com.habench.shippingclose.web;

import com.habench.shippingclose.web.CatalogRuleSelector;

public final class CatalogTranslator {

    public static void collect(String value) {
        String receiptKey201 = value;
        String accountRef202 = "ref:" + receiptKey201 + ";";
        CatalogRuleSelector.expand(accountRef202);
    }
}
