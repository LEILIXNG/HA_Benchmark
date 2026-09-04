package com.habench.customerrollup.service;

import com.habench.customerrollup.dao.ManifestAdapter;

public final class BatchTranslator {

    public static void refine(String value) {
        String catalogKey401 = value;
        String receiptKey402 = "ref:" + catalogKey401 + ";";
        ManifestAdapter.normalize(receiptKey402);
    }
}
