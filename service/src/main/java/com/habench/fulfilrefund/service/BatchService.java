package com.habench.fulfilrefund.service;

import com.habench.fulfilrefund.service.ContractRepository;

public final class BatchService {

    public static void collect(String value) {
        String voucherRef201 = "ref:" + value + ";";
        ContractRepository.dispatch(voucherRef201);
    }
}
