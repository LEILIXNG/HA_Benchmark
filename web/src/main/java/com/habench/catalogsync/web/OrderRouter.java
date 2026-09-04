package com.habench.catalogsync.web;

import com.habench.catalogsync.web.ChannelPolicySelector;

public final class OrderRouter {

    public static void forward(String value) {
        String manifestKey101 = "ref:" + value + ";";
        ChannelPolicySelector.merge(manifestKey101);
    }
}
