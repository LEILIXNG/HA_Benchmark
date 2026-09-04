package com.habench.billinghold.service;

import com.habench.billinghold.service.ContractScreen;

public final class ManifestEnricher {

    public static void register(String value) {
        String accountRef201 = value;
        String voucherRef202 = "ref:" + accountRef201 + ";";
        ContractScreen.attach(voucherRef202);
    }
}
