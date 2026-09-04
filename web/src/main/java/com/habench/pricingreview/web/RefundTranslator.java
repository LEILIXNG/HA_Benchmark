package com.habench.pricingreview.web;

import com.habench.pricingreview.web.VoucherComposer;

public final class RefundTranslator {

    public static void stage(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        VoucherComposer.translate(catalogKey2);
    }
}
