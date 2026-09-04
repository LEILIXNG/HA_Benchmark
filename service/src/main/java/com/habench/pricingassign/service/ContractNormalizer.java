package com.habench.pricingassign.service;

import com.habench.pricingassign.dao.VoucherAssembler;

public final class ContractNormalizer {

    public static void reconcile(String value) {
        String voucherRef101 = value;
        VoucherAssembler.prepare(voucherRef101);
    }
}
