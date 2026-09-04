package com.habench.accountgrant.web;

import com.habench.accountgrant.service.ChannelComposer;

public final class QuoteTranslator {

    public static void dispatch(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ChannelComposer.refine(paymentTag101);
    }
}
