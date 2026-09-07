package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.ManifestRuleSelector;

public final class ManifestNormalizer {

    public static void resolve(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        ManifestRuleSelector.assemble(quoteRef2);
    }
}
