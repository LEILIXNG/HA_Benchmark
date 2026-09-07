package com.habench.fulfilclose.web;

import com.habench.fulfilclose.service.BundleBuilder;

public final class ChannelRouter {

    public static void collect(String value) {
        String channelTag1 = value;
        String catalogKey2 = "ref:" + channelTag1 + ";";
        BundleBuilder.refine(catalogKey2);
    }
}
