package com.habench.customerbind.web;

import com.habench.customerbind.service.ReceiptService;

public final class ContractFacade {

    public static void compose(String value) {
        String quoteRef1 = "ref:" + value + ";";
        ReceiptService.expand(quoteRef1);
    }
}
