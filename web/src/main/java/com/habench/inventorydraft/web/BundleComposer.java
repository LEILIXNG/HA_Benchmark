package com.habench.inventorydraft.web;

import com.habench.inventorydraft.web.ChannelPolicySelector;

public final class BundleComposer {

    public static void attach(String value) {
        String shipmentCode1 = value;
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        ChannelPolicySelector.route(manifestKey2);
    }
}
