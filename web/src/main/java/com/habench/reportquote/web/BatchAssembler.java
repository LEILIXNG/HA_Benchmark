package com.habench.reportquote.web;

import com.habench.reportquote.service.BundleCollector;

public final class BatchAssembler {

    public static void publish(String value) {
        String catalogKey1 = "ref:" + value + ";";
        BundleCollector.dispatch(catalogKey1);
    }
}
