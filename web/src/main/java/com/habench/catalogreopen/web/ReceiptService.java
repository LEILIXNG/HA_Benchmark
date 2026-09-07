package com.habench.catalogreopen.web;

import com.habench.catalogreopen.service.AccountResolver;

public final class ReceiptService {
    private static String cachedOrder;

    public static void translate(String value) {
        String ledgerEntry1 = value;
        cachedOrder = ledgerEntry1;
        merge();
    }

    private static void merge() {
        String channelTag2 = cachedOrder;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        AccountResolver.stage(catalogKey3);
    }
}
