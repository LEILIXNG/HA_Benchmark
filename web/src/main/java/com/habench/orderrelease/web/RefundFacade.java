package com.habench.orderrelease.web;

import com.habench.orderrelease.service.ContractRegistry;

public final class RefundFacade {

    public static void resolve(String value) {
        String batchTag101 = "ref:" + value + ";";
        ContractRegistry.enrich(batchTag101);
    }
}
