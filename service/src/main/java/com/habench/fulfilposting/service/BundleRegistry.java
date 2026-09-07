package com.habench.fulfilposting.service;

import com.habench.fulfilposting.service.BatchResolver;

public final class BundleRegistry {

    public static void dispatch(String value) {
        String accountRef301 = "ref:" + value + ";";
        BatchResolver.expand(accountRef301);
    }
}
