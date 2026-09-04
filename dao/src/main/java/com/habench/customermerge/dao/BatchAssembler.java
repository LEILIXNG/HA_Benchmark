package com.habench.customermerge.dao;

import com.habench.customermerge.dao.ManifestPolicySelector;

public final class BatchAssembler {
    private static String cachedAccount;

    public static void resolve(String value) {
        String manifestKey301 = "ref:" + value + ";";
        cachedAccount = manifestKey301;
        expand();
    }

    private static void expand() {
        String invoiceKey302 = cachedAccount;
        String batchTag303 = "ref:" + invoiceKey302 + ";";
        String orderRef304 = batchTag303;
        ManifestPolicySelector.resolve(orderRef304);
    }
}
