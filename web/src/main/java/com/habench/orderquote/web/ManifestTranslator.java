package com.habench.orderquote.web;

import com.habench.orderquote.service.BundleTranslator;

public final class ManifestTranslator {

    public static void reconcile(String value) {
        String tariffRef1 = "ref:" + value + ";";
        BundleTranslator.route(tariffRef1);
    }
}
