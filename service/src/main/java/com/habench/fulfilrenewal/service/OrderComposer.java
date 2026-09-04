package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.service.ContractRepository;

public final class OrderComposer {

    public static void forward(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        ContractRepository.expand(ledgerEntry301);
    }
}
