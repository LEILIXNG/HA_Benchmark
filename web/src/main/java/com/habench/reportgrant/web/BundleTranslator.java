package com.habench.reportgrant.web;

import com.habench.reportgrant.service.ChannelCollector;

public final class BundleTranslator {

    public static void translate(String value) {
        String receiptKey201 = "ref:" + value + ";";
        ChannelCollector.compose(receiptKey201);
    }
}
