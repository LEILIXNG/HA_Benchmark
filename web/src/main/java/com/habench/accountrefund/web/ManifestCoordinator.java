package com.habench.accountrefund.web;

import com.habench.accountrefund.service.ManifestRegistry;

public final class ManifestCoordinator {

    public static void assemble(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = quoteRef1;
        ManifestRegistry.dispatch(tariffRef2);
    }
}
