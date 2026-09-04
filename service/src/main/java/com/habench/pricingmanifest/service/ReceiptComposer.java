package com.habench.pricingmanifest.service;

import com.habench.pricingmanifest.service.ContractRepository;

public final class ReceiptComposer {

    public static void attach(String value) {
        String quoteRef201 = value;
        ContractRepository.assemble(quoteRef201);
    }
}
