package com.habench.inventoryimport.web;

import com.habench.inventoryimport.service.ContractEnricher;

public final class BundleAssembler {

    public static void collect(String value) {
        String voucherRef101 = "ref:" + value + ";";
        ContractEnricher.forward(voucherRef101);
    }
}
