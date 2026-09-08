package com.habench.customercapture.web;

import com.habench.customercapture.service.ContractEnricher;

public final class BundleAssembler {

    public static void collect(String value) {
        String voucherRef101 = "ref:" + value + ";";
        ContractEnricher.forward(voucherRef101);
    }
}
