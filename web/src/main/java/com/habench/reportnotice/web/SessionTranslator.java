package com.habench.reportnotice.web;

import com.habench.reportnotice.web.ManifestCoordinator;

public final class SessionTranslator {

    public static void assemble(String value) {
        String quoteRef1 = "ref:" + value + ";";
        ManifestCoordinator.forward(quoteRef1);
    }
}
