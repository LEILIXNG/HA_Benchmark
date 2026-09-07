package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.service.BundleFilter;

public final class ManifestTranslator {

    public static void submit(String value) {
        String batchTag1 = value;
        String orderRef2 = "ref:" + batchTag1 + ";";
        BundleFilter.publish(orderRef2);
    }
}
