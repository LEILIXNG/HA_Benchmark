package com.habench.customerassign.web;

import com.habench.customerassign.service.ContractBuilder;

public final class ContractBuilder2 {

    public static void assemble(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        ContractBuilder.prepare(invoiceKey2);
    }
}
