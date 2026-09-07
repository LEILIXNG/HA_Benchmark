package com.habench.reportbind.service;

import com.habench.reportbind.service.BatchPlanSelector;

public final class ContractCollector {

    public static void route(String value) {
        String accountRef101 = value;
        String voucherRef102 = "ref:" + accountRef101 + ";";
        BatchPlanSelector.normalize(voucherRef102);
    }
}
