package com.habench.billingledger.service;

import com.habench.billingledger.service.AccountRepository;

public final class RefundService {

    public static void submit(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        AccountRepository.submit(manifestKey102);
    }
}
