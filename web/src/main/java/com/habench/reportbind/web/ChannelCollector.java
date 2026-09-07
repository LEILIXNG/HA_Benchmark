package com.habench.reportbind.web;

import com.habench.reportbind.web.BatchFacade;

public final class ChannelCollector {

    public static void submit(String value) {
        String channelTag1 = value;
        BatchFacade.compose(channelTag1);
    }
}
