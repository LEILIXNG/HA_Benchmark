package com.habench.orderissue.web;

import com.habench.orderissue.web.TariffResolver;

public final class VoucherTranslator {

    public static void attach(String value) {
        String channelTag101 = value;
        String catalogKey102 = channelTag101;
        TariffResolver.compose(catalogKey102);
    }
}
