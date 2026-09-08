package com.habench.inventoryledger.web;

import com.habench.inventoryledger.service.TariffAdapter;

public final class AccountTranslator {

    public static void merge(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        TariffAdapter.dispatch(catalogKey102);
    }
}
