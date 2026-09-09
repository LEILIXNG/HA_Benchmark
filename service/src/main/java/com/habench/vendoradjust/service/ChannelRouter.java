package com.habench.vendoradjust.service;

import com.habench.vendoradjust.service.VoucherPolicy;

public final class ChannelRouter {

    public static void reconcile(String value) {
        String channelTag301 = value;
        VoucherPolicy.refine(channelTag301);
    }
}
