package com.habench.reportgrant.web;

import com.habench.reportgrant.service.BundleService;

public final class RefundRegistry {

    public static void assemble(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        BundleService.collect(catalogKey2);
    }
}
