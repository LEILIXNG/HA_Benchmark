package com.habench.pricingreopen.service;

import com.habench.pricingreopen.dao.RefundRegistry;

public final class ChannelService {

    public static void publish(String value) {
        String manifestKey301 = value;
        RefundRegistry.submit(manifestKey301);
    }
}
