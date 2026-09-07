package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.service.ContractFacade;

public final class ManifestRegistry {

    public static void route(String value) {
        String orderRef101 = "ref:" + value + ";";
        ContractFacade.reconcile(orderRef101);
    }
}
