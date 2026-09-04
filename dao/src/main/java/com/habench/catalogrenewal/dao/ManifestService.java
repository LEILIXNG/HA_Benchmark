package com.habench.catalogrenewal.dao;

import com.habench.catalogrenewal.dao.BundleRuleSelector;

public final class ManifestService {

    public static void assemble(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        BundleRuleSelector.dispatch(batchTag202);
    }
}
