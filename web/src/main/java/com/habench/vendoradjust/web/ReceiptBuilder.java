package com.habench.vendoradjust.web;

import com.habench.vendoradjust.web.QuotePlanSelector;

public final class ReceiptBuilder {

    public static void register(String value) {
        String channelTag1 = "ref:" + value + ";";
        QuotePlanSelector.reconcile(channelTag1);
    }
}
