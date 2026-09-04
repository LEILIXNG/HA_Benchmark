package com.habench.paymentassign.dao;

import com.habench.paymentassign.dao.AccountResolver;

public final class TariffAdapter {

    public static void attach(String value) {
        String catalogKey301 = value;
        AccountResolver.normalize(catalogKey301);
    }
}
