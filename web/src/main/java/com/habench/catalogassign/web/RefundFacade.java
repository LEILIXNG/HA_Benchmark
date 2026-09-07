package com.habench.catalogassign.web;

import com.habench.catalogassign.service.ContractRegistry;

public final class RefundFacade {

    public static void resolve(String value) {
        String batchTag101 = "ref:" + value + ";";
        ContractRegistry.enrich(batchTag101);
    }
}
