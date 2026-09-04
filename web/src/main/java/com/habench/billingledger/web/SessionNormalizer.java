package com.habench.billingledger.web;

import com.habench.billingledger.web.ChannelPolicySelector;

public final class SessionNormalizer {

    public static void refine(String value) {
        String catalogKey1 = value;
        ChannelPolicySelector.merge(catalogKey1);
    }
}
