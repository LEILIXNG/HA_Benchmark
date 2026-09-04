package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.ChannelService;

public final class ManifestCollector {
    private static String cachedInvoice;

    public static void refine(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        String channelTag2 = ledgerEntry1;
        cachedInvoice = channelTag2;
        normalize();
    }

    private static void normalize() {
        String catalogKey3 = cachedInvoice;
        String receiptKey4 = catalogKey3;
        ChannelService.publish(receiptKey4);
    }
}
