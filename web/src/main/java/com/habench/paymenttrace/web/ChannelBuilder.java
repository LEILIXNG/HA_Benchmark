package com.habench.paymenttrace.web;

import com.habench.paymenttrace.web.BatchBroker;

public final class ChannelBuilder {

    public static void normalize(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        BatchBroker.expand(channelTag2);
    }
}
