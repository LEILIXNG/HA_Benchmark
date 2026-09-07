package com.habench.pricingreview.service;

import com.habench.pricingreview.service.ContractNormalizer;

public final class AccountResolver {

    public static void forward(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        ContractNormalizer.enrich(manifestKey102);
    }
}
