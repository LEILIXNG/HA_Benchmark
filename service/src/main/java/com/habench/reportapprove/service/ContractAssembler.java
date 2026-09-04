package com.habench.reportapprove.service;

import com.habench.reportapprove.service.AccountLoader;

public final class ContractAssembler {

    public static void forward(String value) {
        String batchTag601 = "ref:" + value + ";";
        AccountLoader.assemble(batchTag601);
    }
}
