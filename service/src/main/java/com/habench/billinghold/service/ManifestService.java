package com.habench.billinghold.service;

import com.habench.billinghold.service.AccountCollector;

public final class ManifestService {

    public static void collect(String value) {
        String manifestKey301 = value;
        AccountCollector.translate(manifestKey301);
    }
}
