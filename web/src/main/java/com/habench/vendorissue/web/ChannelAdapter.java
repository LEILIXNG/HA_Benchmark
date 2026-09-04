package com.habench.vendorissue.web;

import com.habench.vendorissue.web.InvoiceTranslator;

public final class ChannelAdapter {

    public static void compose(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        InvoiceTranslator.expand(catalogKey102);
    }
}
