package com.habench.vendorreopen.service;

import com.habench.vendorreopen.service.SessionStrategySelector;

public final class SessionCoordinator {
    private static String cachedAccount;

    public static void resolve(String value) {
        String ledgerEntry101 = value;
        String channelTag102 = ledgerEntry101;
        cachedAccount = channelTag102;
        forward();
    }

    private static void forward() {
        String catalogKey103 = cachedAccount;
        String receiptKey104 = catalogKey103;
        SessionStrategySelector.resolve(receiptKey104);
    }
}
