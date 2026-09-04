package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.BundleNormalizer;

public final class ChannelResolver {

    public static void submit(String value) {
        String channelTag201 = "ref:" + value + ";";
        BundleNormalizer.refine(channelTag201);
    }
}
