package com.habench.vendorledger.web;

import com.habench.vendorledger.web.ChannelFacade;

public final class ReceiptNormalizer {

    public static void resolve(String value) {
        String receiptKey1 = "ref:" + value + ";";
        ChannelFacade.refine(receiptKey1);
    }
}
