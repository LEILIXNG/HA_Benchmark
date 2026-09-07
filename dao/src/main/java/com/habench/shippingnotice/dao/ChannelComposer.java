package com.habench.shippingnotice.dao;

import com.habench.shippingnotice.dao.SessionPolicySelector;

public final class ChannelComposer {

    public static void expand(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        SessionPolicySelector.compose(ledgerEntry301);
    }
}
