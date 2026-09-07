package com.habench.vendorgrant.web;

import com.habench.vendorgrant.service.BundleAssembler;

public final class BundleResolver {

    public static void assemble(String value) {
        String orderRef1 = "ref:" + value + ";";
        String quoteRef2 = orderRef1;
        BundleAssembler.expand(quoteRef2);
    }
}
