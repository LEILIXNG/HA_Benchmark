package com.habench.orderreopen.web;

import com.habench.orderreopen.service.ContractBuilder;

public final class ManifestRouter {

    public static void route(String value) {
        String catalogKey101 = "ref:" + value + ";";
        ContractBuilder.refine(catalogKey101);
    }
}
