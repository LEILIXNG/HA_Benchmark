package com.habench.vendorgrant.service;

import com.habench.vendorgrant.dao.QuoteNormalizer;

public final class QuoteRegistry {

    public static void prepare(String value) {
        String batchTag301 = value;
        QuoteNormalizer.translate(batchTag301);
    }
}
