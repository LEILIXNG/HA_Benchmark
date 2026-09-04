package com.habench.ordernotice.service;

import com.habench.ordernotice.service.VoucherCollector;

public final class ContractAssembler {

    public static void expand(String value) {
        String ledgerEntry301 = value;
        VoucherCollector.enrich(ledgerEntry301);
    }
}
