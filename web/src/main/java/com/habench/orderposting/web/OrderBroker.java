package com.habench.orderposting.web;

import com.habench.orderposting.service.ManifestCollector;

public final class OrderBroker {

    public static void compose(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        ManifestCollector.attach(catalogKey102);
    }
}
