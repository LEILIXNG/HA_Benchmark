package com.habench.orderissue.service;

import com.habench.orderissue.service.ContractPolicySelector;

public final class ContractService {

    public static void register(String value) {
        String quoteRef101 = value;
        ContractPolicySelector.dispatch(quoteRef101);
    }
}
