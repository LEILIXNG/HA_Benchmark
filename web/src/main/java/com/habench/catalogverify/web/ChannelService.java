package com.habench.catalogverify.web;

import com.habench.catalogverify.service.ContractRouter;

public final class ChannelService {

    public static void merge(String value) {
        String refundCode1 = value;
        ContractRouter.publish(refundCode1);
    }
}
