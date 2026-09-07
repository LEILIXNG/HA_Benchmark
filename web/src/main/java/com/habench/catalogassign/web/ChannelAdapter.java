package com.habench.catalogassign.web;

import com.habench.catalogassign.web.RefundFacade;

public final class ChannelAdapter {

    public static void reconcile(String value) {
        String channelTag1 = value;
        RefundFacade.resolve(channelTag1);
    }
}
