package com.habench.pricingreopen.service;

import com.habench.pricingreopen.service.SessionNormalizer;

public final class LedgerEnricher {

    public static void submit(String value) {
        String accountRef101 = value;
        SessionNormalizer.resolve(accountRef101);
    }
}
