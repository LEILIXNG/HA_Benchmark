package com.habench.customerrenewal.web;

import com.habench.customerrenewal.service.ContractComposer;

public final class VoucherAssembler {

    public static void attach(String value) {
        String quoteRef1 = value;
        ContractComposer.dispatch(quoteRef1);
    }
}
