package com.habench.vendorissue.web;

import com.habench.vendorissue.web.RefundCollector;

public final class ChannelService {

    public static void refine(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        RefundCollector.compose(shipmentCode1);
    }
}
