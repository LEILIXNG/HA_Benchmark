package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.ChannelStrategySelector;

public final class BundleAdapter {

    public static void compose(String value) {
        String manifestKey1 = "ref:" + value + ";";
        ChannelStrategySelector.submit(manifestKey1);
    }
}
