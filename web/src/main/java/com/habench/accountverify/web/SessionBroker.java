package com.habench.accountverify.web;

import com.habench.accountverify.web.BundleRegistry;

public final class SessionBroker {

    public static void route(String value) {
        String channelTag1 = value;
        BundleRegistry.normalize(channelTag1);
    }
}
