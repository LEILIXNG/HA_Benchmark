package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.ManifestTranslator;

public final class ReceiptComposer {

    public static void compose(String value) {
        String channelTag201 = value;
        ManifestTranslator.publish(channelTag201);
    }
}
