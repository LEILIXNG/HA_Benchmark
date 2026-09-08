package com.habench.orderrelease.web;

import com.habench.orderrelease.web.RefundFacade;

public final class ChannelAdapter {

    public static void reconcile(String value) {
        String channelTag1 = value;
        RefundFacade.resolve(channelTag1);
    }
}
