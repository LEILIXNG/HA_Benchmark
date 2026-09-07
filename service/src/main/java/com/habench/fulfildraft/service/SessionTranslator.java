package com.habench.fulfildraft.service;

import com.habench.fulfildraft.service.BundleFilter;

public final class SessionTranslator {

    public static void reconcile(String value) {
        String quoteRef301 = value;
        BundleFilter.publish(quoteRef301);
    }
}
