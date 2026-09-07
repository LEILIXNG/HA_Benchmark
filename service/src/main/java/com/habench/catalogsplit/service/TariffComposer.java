package com.habench.catalogsplit.service;

import com.habench.catalogsplit.service.ContractPlanSelector;

public final class TariffComposer {
    private static String cachedAccount;

    public static void merge(String value) {
        String quoteRef101 = "ref:" + value + ";";
        cachedAccount = quoteRef101;
        compose();
    }

    private static void compose() {
        String tariffRef102 = cachedAccount;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        ContractPlanSelector.prepare(channelTag104);
    }
}
