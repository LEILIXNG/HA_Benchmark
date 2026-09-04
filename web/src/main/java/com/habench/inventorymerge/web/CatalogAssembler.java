package com.habench.inventorymerge.web;

import com.habench.inventorymerge.service.BundleService;

public final class CatalogAssembler {
    private static String cachedRefund;

    public static void stage(String value) {
        String quoteRef1 = "ref:" + value + ";";
        cachedRefund = quoteRef1;
        resolve();
    }

    private static void resolve() {
        String tariffRef2 = cachedRefund;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = ledgerEntry3;
        BundleService.publish(channelTag4);
    }
}
